

package com.cortaYa.aplicacion.infraestructura.api;

import com.cortaYa.aplicacion.dominio.dtos.DireccionResponseDTO;
import com.cortaYa.aplicacion.dominio.model.Localidad;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ApiDireccionClient {

    private final RestTemplate restTemplate = new RestTemplate();
    @Value("${spring.external.service.baseDirecciones-url}")
    private String BASE_URL;

    public List<String> obtenerDirecciones(Localidad localidad, String query) {
        try {
            String url = BASE_URL
                    + "?direccion=" + URLEncoder.encode(query, StandardCharsets.UTF_8)
                    + "&localidad=" + URLEncoder.encode(localidad.getNombre(), StandardCharsets.UTF_8)
                    + "&max=20";

            DireccionResponseDTO response = restTemplate.getForObject(url, DireccionResponseDTO.class);

            if (response != null && response.getDirecciones() != null) {
                return response.getDirecciones().stream()
                        .map(d -> {
                            String calle = d.getCalle() != null ? d.getCalle().getNombre() : "";
                            String altura = (d.getAltura() != null && d.getAltura().getValor() != null)
                                    ? d.getAltura().getValor().toString()
                                    : "";
                            return calle + (altura.isEmpty() ? "" : " " + altura);
                        })
                        .distinct() // <-- elimina duplicados
                        .collect(Collectors.toList());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return List.of();
    }

}
