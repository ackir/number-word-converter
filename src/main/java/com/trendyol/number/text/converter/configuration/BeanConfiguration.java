package com.trendyol.number.text.converter.configuration;

import com.trendyol.number.text.converter.util.GenericConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public GenericConverter genericConverter() {
        return new GenericConverter();
    }
}
