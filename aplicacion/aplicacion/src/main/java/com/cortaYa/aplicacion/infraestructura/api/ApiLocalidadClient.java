package com.cortaYa.aplicacion.infraestructura.api;

import com.cortaYa.aplicacion.dominio.dtos.LocalidadDTO;
import com.cortaYa.aplicacion.dominio.dtos.LocalidadResponseDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
public class ApiLocalidadClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String BASE_URL = "https://apis.datos.gob.ar/georef/api/localidades";

    // Lista de partidos del AMBA
    private static final String[] AMBA_PARTIDOS = {
            "Avellaneda", "Lanús", "Quilmes", "Lomas de Zamora", "Almirante Brown",
            "San Isidro", "Vicente López", "San Fernando", "Tigre", "Pilar",
            "Escobar", "José C. Paz", "Hurlingham", "Merlo", "Morón",
            "Malvinas Argentinas", "General San Martín", "Tres de Febrero", "San Miguel",
            "La Matanza"
    };

    public List<LocalidadDTO> obtenerLocalidadesAMBA() {
        List<LocalidadDTO> localidades = new ArrayList<>();

        // Primero, agregamos CABA
        String urlCABA = BASE_URL + "?provincia=02&max=5000";
        LocalidadResponseDTO respCABA = restTemplate.getForObject(urlCABA, LocalidadResponseDTO.class);
        if (respCABA != null && respCABA.getLocalidades() != null) {
            localidades.addAll(respCABA.getLocalidades());
        }

        // Luego, recorremos cada partido del AMBA
        for (String partido : AMBA_PARTIDOS) {
            try {
                String urlPartido = BASE_URL + "?provincia=06&municipio=" +
                        URLEncoder.encode(partido, StandardCharsets.UTF_8) + "&max=5000";
                LocalidadResponseDTO respPartido = restTemplate.getForObject(urlPartido, LocalidadResponseDTO.class);
                if (respPartido != null && respPartido.getLocalidades() != null) {
                    localidades.addAll(respPartido.getLocalidades());
                }
            } catch (Exception e) {
                System.out.println("Error al traer localidades de " + partido + ": " + e.getMessage());
            }
        }

        return localidades;
    }
}
