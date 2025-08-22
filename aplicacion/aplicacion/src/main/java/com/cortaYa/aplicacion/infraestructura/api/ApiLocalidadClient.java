package com.cortaYa.aplicacion.infraestructura.api;

import com.cortaYa.aplicacion.dominio.model.Localidad;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiLocalidadClient {

    private final RestTemplate restTemplate;
    private final String API_URL = "https://unpkg.com/leaflet/dist/leaflet.js";

    public ApiLocalidadClient() {
        this.restTemplate = new RestTemplate();
    }

    public Localidad[] obtenerLocalidades() {
        return restTemplate.getForObject(API_URL, Localidad[].class);
    }
}
