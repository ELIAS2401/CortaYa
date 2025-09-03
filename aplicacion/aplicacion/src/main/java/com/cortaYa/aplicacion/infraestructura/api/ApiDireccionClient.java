

package com.cortaYa.aplicacion.infraestructura.api;

import com.cortaYa.aplicacion.dominio.model.Localidad;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ApiDireccionClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String BASE_URL = "https://apis.datos.gob.ar/georef/api/direcciones";

    public List<String> obtenerDirecciones(Localidad localidad, String query) {
        try {
            String url = BASE_URL
                    + "?direccion=" + URLEncoder.encode(query, StandardCharsets.UTF_8)
                    + "&localidad=" + URLEncoder.encode(localidad.getNombre(), StandardCharsets.UTF_8)
                    + "&max=20";

            GeoRefResponse response = restTemplate.getForObject(url, GeoRefResponse.class);

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


    // ---- Clases internas para mapear la respuesta ----

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class GeoRefResponse {
        private List<Direccion> direcciones;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Direccion {
        private Altura altura;
        private Calle calle;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Altura {
        private Integer valor;
        private String unidad;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Calle {
        private String id;
        private String nombre;
        private String categoria;
    }

}
