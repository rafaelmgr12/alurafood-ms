package br.com.alurafood.pagamentos.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationModelMapper {
    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
