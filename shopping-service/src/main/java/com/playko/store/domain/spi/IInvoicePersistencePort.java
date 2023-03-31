package com.playko.store.domain.spi;

import com.playko.store.domain.model.InvoiceModel;

import java.util.List;

public interface IInvoicePersistencePort {
    List<InvoiceModel> findInvoiceAll();
    InvoiceModel getInvoice(Long id);
    void createInvoice(InvoiceModel invoice);
    void updateInvoice(InvoiceModel invoice);
    void deleteInvoice(Long id);
}
