package com.playko.store.domain.api;

import com.playko.store.domain.model.InvoiceModel;

import java.util.List;

public interface IInvoiceServicePort {
    List<InvoiceModel> findInvoiceAll();
    InvoiceModel getInvoice(Long id);
    void createInvoice(InvoiceModel invoice);
    void updateInvoice(InvoiceModel invoice);
    InvoiceModel deleteInvoice(Long id);

}
