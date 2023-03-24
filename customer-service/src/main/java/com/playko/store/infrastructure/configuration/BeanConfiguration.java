package com.playko.store.infrastructure.configuration;

import com.playko.store.domain.api.ICustumerServicePort;
import com.playko.store.domain.spi.ICustomerPersistencePort;
import com.playko.store.domain.usecase.CustumerUseCase;
import com.playko.store.infrastructure.exception.ErrorMessage;
import com.playko.store.infrastructure.out.jpa.adapter.CustomerJpaAdapter;
import com.playko.store.infrastructure.out.jpa.mapper.ICustomerEntityMapper;
import com.playko.store.infrastructure.out.jpa.repository.ICustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    @Bean("customerrPersistencePort")
    public ICustomerPersistencePort customerPersistencePort(ICustomerRepository customerRepository, ICustomerEntityMapper customerEntityMapper){
        return new CustomerJpaAdapter(customerRepository, customerEntityMapper);
    }

    @Bean("customerServicePort")
    public ICustumerServicePort custumerServicePort(ICustomerPersistencePort customerPersistencePort){
        return new CustumerUseCase(customerPersistencePort);
    }

    @Bean
    public ErrorMessage errorMesagge() {
        return new ErrorMessage();
    }
}
