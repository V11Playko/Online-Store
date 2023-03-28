package com.playko.store.domain.usecase;

import com.playko.store.domain.api.IInvoiceServicePort;
import com.playko.store.domain.model.InvoiceModel;
import com.playko.store.domain.spi.IInvoicePersistencePort;

import java.util.List;

public class InvoiceUseCase implements IInvoiceServicePort {
    private final IInvoicePersistencePort invoicePersistencePort;
    public InvoiceUseCase(IInvoicePersistencePort invoicePersistencePort) {
        this.invoicePersistencePort = invoicePersistencePort;
    }

    @Override
    public List<InvoiceModel> findInvoiceAll() {
        return invoicePersistencePort.findInvoiceAll();
    }

    @Override
    public InvoiceModel getInvoice(Long id) {
        return invoicePersistencePort.getInvoice(id);
    }

    @Override
    public void createInvoice(InvoiceModel invoice) {
        invoicePersistencePort.createInvoice(invoice);
    }

    @Override
    public void updateInvoice(InvoiceModel invoice) {
        invoicePersistencePort.updateInvoice(invoice);
    }

    @Override
    public InvoiceModel deleteInvoice(Long id) {
        invoicePersistencePort.deleteInvoice(id);
        return null;
    }
}
