package com.cortaYa.aplicacion.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
    //Creamos el Bean de RestTemplate para que pueda ser utilizado en nuestro microservicio.
    //Con esto springboot lo detecta como un servicio inicializado
    //Definimos con esto el RestTemplate

    //Lo más limpio es tener un bean de RestTemplate configurado en una clase @Configuration.
    //🔹 ¿Por qué es mejor usar un @Configuration con RestTemplateBuilder?
    //Reutilización: en lugar de crear un RestTemplate nuevo en cada client, todos los beans de tu app usan el mismo.
    //Configuración centralizada: si querés agregar interceptores, timeouts, logging, headers comunes, etc., lo hacés en un solo lugar.
    //Integración con Spring Boot: RestTemplateBuilder ya trae configuraciones de message converters y soporte de Jackson para JSON.
}
