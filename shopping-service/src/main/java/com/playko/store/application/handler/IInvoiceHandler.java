package com.playko.store.application.handler;

import com.playko.store.application.dto.request.InvoiceRequestDto;
import com.playko.store.application.dto.response.InvoiceResponseDto;

import java.util.List;

public interface IInvoiceHandler {
    List<InvoiceResponseDto> listAllInvoice();
    InvoiceResponseDto getInvoice(Long id);
    void createInvoice(InvoiceRequestDto invoice);
    void updateInvoice(InvoiceRequestDto invoice);
    void deleteInvoice(Long id);
}
