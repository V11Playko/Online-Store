package com.playko.store.infrastructure.out.jpa.adapter;

import com.playko.store.infrastructure.client.CustomerClient;
import com.playko.store.infrastructure.client.ProductClient;
import com.playko.store.domain.feign.Customer;
import com.playko.store.domain.feign.Product;
import com.playko.store.domain.model.InvoiceModel;
import com.playko.store.domain.model.ItemModel;
import com.playko.store.domain.spi.IInvoicePersistencePort;
import com.playko.store.infrastructure.exception.NoDataFoundException;
import com.playko.store.infrastructure.out.jpa.entity.InvoiceEntity;
import com.playko.store.infrastructure.out.jpa.entity.ItemEntity;
import com.playko.store.infrastructure.out.jpa.mapper.IInvoiceEntityMapper;
import com.playko.store.infrastructure.out.jpa.repository.IInvoiceRepository;
import com.playko.store.infrastructure.out.jpa.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class InvoiceJpaAdapter implements IInvoicePersistencePort {
    private final IInvoiceRepository invoiceRepository;
    private final ItemRepository itemRepository;
    private final IInvoiceEntityMapper invoiceEntityMapper;

    @Autowired
    CustomerClient customerClient;
    @Autowired
    ProductClient productClient;

    @Override
    public List<InvoiceModel> findInvoiceAll() {
        List<InvoiceEntity> invoiceEntityList = invoiceRepository.findAll();
        if (invoiceEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return invoiceEntityMapper.toInvoiceModelList(invoiceEntityList);
    }

    @Override
    public InvoiceModel getInvoice(Long id) {
        InvoiceModel invoice = invoiceEntityMapper.toInvoiceModel(invoiceRepository.findById(id).get());
        if (null != invoice ){
            Customer customer = customerClient.getCustomer(invoice.getCustomerId()).getBody();
            invoice.setCustomer(customer);
            List<ItemModel> listItem=invoice.getItems().stream().map(invoiceItem -> {
                Product product = productClient.getProduct(invoiceItem.getProductId()).getBody();
                invoiceItem.setProduct(product);
                return invoiceItem;
            }).collect(Collectors.toList());
            invoice.setItems(listItem);
        }
        return invoice ;
    }

    @Override
    public void createInvoice(InvoiceModel invoice) {
        InvoiceEntity invoiceEntity = InvoiceEntity.ofInvoiceModel(invoice);
        invoiceEntity = invoiceRepository.save(invoiceEntity);
        invoiceEntity.getItems().forEach( invoiceItem ->{
            productClient.updateStockProduct( invoiceItem.getProductId(),
                    invoiceItem.getQuantityItem() * -1);
        });
        for (ItemEntity itemEntity : invoiceEntity.getItems()) {
            itemEntity.setInvoice(InvoiceEntity.builder().id(invoiceEntity.getId()).build());
            itemRepository.save(itemEntity);
        }
    }

    @Override
    public void updateInvoice(InvoiceModel invoice) {
        invoiceRepository.save(InvoiceEntity.ofInvoiceModel(invoice));
    }

    @Override
    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }
}
