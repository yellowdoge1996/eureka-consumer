package com.example.eurekaconsumer.configuration;


import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultipartSupportConfig {
    @Bean
    public Encoder feignFromEncoder(){
        return new SpringFormEncoder();
    }
}
