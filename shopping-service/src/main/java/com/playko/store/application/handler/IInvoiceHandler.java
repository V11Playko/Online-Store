package com.playko.store.application.handler;

import com.playko.store.application.dto.request.SaveInvoiceRequestDto;
import com.playko.store.application.dto.request.UpdateInvoiceRequestDto;
import com.playko.store.application.dto.response.InvoiceResponseDto;

import java.util.List;

public interface IInvoiceHandler {
    List<InvoiceResponseDto> listAllInvoice();

    InvoiceResponseDto getInvoice(Long id);

    void createInvoice(SaveInvoiceRequestDto invoice);

    void updateInvoice(UpdateInvoiceRequestDto invoice);

    void deleteInvoice(Long id);
}
