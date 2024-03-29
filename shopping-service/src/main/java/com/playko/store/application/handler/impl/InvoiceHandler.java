package com.playko.store.application.handler.impl;

import com.playko.store.application.dto.request.SaveInvoiceRequestDto;
import com.playko.store.application.dto.request.UpdateInvoiceRequestDto;
import com.playko.store.application.dto.response.InvoiceResponseDto;
import com.playko.store.application.handler.IInvoiceHandler;
import com.playko.store.application.mapper.IInvoiceRequestMapper;
import com.playko.store.application.mapper.IInvoiceResponseMapper;
import com.playko.store.domain.api.IInvoiceServicePort;
import com.playko.store.domain.model.InvoiceModel;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class InvoiceHandler implements IInvoiceHandler {
    private final IInvoiceServicePort invoiceServicePort;

    private final IInvoiceRequestMapper invoiceRequestMapper;

    private final IInvoiceResponseMapper invoiceResponseMapper;


    @Override
    public List<InvoiceResponseDto> listAllInvoice() {
        return invoiceResponseMapper.toResponseInvoiceList(invoiceServicePort.findInvoiceAll());
    }

    @Override
    public InvoiceResponseDto getInvoice(Long id) {
        InvoiceModel invoice = invoiceServicePort.getInvoice(id);
        return invoiceResponseMapper.toResponseGetInvoice(invoice);
    }

    @Override
    public void createInvoice(SaveInvoiceRequestDto invoiceRequest) {
        InvoiceModel invoiceModel = invoiceRequest.toInvoiceModel();
        invoiceServicePort.createInvoice(invoiceModel);
    }

    @Override
    public void updateInvoice(UpdateInvoiceRequestDto invoice) {
        InvoiceModel invoiceModel = invoiceServicePort.getInvoice(invoice.toInvoice().getId());
        if (Strings.isNotBlank(invoice.getDescription()) || Strings.isNotEmpty(invoice.getDescription()))
            invoiceModel.setDescription(invoiceModel.getDescription());

        invoiceModel.setNumber(invoice.getNumber());
        invoiceModel.setDescription(invoice.getDescription());
        invoiceModel.setCustomerId(invoice.getCustomerId());

        invoiceServicePort.updateInvoice(invoiceModel);
    }

    @Override
    public void deleteInvoice(Long id) {
        InvoiceModel invoiceModel = invoiceServicePort.deleteInvoice(id);
    }
}
