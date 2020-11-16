package com.casestudy.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class ValidateConfig {
    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
        messageSource.setBasename("message_validate");
        return messageSource;
    }
}
