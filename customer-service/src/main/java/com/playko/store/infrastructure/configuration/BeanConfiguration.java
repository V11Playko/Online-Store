package com.playko.store.infrastructure.configuration;

import com.playko.store.infrastructure.exception.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    @Bean
    public ErrorMessage errorMesagge() {
        return new ErrorMessage();
    }
}
