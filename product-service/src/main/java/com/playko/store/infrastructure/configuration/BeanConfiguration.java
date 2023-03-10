package com.playko.store.infrastructure.configuration;

import com.playko.store.domain.api.IProductServicePort;
import com.playko.store.domain.spi.IProductPersistencePort;
import com.playko.store.domain.usecase.ProductUseCase;
import com.playko.store.infrastructure.exception.ErrorMessage;
import com.playko.store.infrastructure.out.jpa.adapter.ProductJpaAdapter;
import com.playko.store.infrastructure.out.jpa.mapper.IProductEntityMapper;
import com.playko.store.infrastructure.out.jpa.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    @Bean
    public IProductPersistencePort productPersistencePort(IProductRepository productRepository, IProductEntityMapper productEntityMapper){
        return new ProductJpaAdapter(productRepository, productEntityMapper);
    }

    @Bean
    public IProductServicePort productServicePort(IProductPersistencePort productPersistencePort) {
        return new ProductUseCase(productPersistencePort);
    }

    @Bean
    public ErrorMessage errorMessage() {
        return new ErrorMessage();
    }
}
