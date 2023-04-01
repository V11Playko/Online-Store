package com.playko.store.infrastructure.out.jpa.adapter;

import com.playko.store.domain.model.InvoiceModel;
import com.playko.store.domain.spi.IInvoicePersistencePort;
import com.playko.store.infrastructure.exception.NoDataFoundException;
import com.playko.store.infrastructure.out.jpa.entity.InvoiceEntity;
import com.playko.store.infrastructure.out.jpa.entity.ItemEntity;
import com.playko.store.infrastructure.out.jpa.mapper.IInvoiceEntityMapper;
import com.playko.store.infrastructure.out.jpa.repository.IInvoiceRepository;
import com.playko.store.infrastructure.out.jpa.repository.ItemRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class InvoiceJpaAdapter implements IInvoicePersistencePort {
    private final IInvoiceRepository invoiceRepository;
    private final ItemRepository itemRepository;
    private final IInvoiceEntityMapper invoiceEntityMapper;

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
        return invoiceEntityMapper.toInvoiceModel(invoiceRepository.findById(id).get());
    }

    @Override
    public void createInvoice(InvoiceModel invoice) {
        InvoiceEntity invoiceEntity = InvoiceEntity.ofInvoiceModel(invoice);
        invoiceEntity = invoiceRepository.save(invoiceEntity);
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
