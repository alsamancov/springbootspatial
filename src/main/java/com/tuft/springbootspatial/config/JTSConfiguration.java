package com.tuft.springbootspatial.config;

import com.bedatadriven.jackson.datatype.jts.JtsModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class JTSConfiguration extends ObjectMapper {
    private static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper().registerModule(new JtsModule());
    }

    @Bean
    @Primary
    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }
}
