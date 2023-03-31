package com.playko.store.infrastructure.configuration;

import com.playko.store.domain.api.IInvoiceServicePort;
import com.playko.store.domain.spi.IInvoicePersistencePort;
import com.playko.store.domain.usecase.InvoiceUseCase;
import com.playko.store.infrastructure.out.jpa.adapter.InvoiceJpaAdapter;
import com.playko.store.infrastructure.out.jpa.mapper.IInvoiceEntityMapper;
import com.playko.store.infrastructure.out.jpa.repository.IInvoiceRepository;
import lombok.RequiredArgsConstructor;
import com.playko.store.infrastructure.exception.ErrorMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    @Bean("invoicePersistencePort")
    public IInvoicePersistencePort invoicePersistencePort(IInvoiceRepository invoiceRepository, IInvoiceEntityMapper invoiceEntityMapper){
        return new InvoiceJpaAdapter(invoiceRepository, invoiceEntityMapper);
    }

    @Bean("invoiceServicePort")
    public IInvoiceServicePort invoiceServicePort(IInvoicePersistencePort invoicePersistencePort){
        return new InvoiceUseCase(invoicePersistencePort);
    }
    @Bean
    public ErrorMessage errorMesagge() {
        return new ErrorMessage();
    }
}
