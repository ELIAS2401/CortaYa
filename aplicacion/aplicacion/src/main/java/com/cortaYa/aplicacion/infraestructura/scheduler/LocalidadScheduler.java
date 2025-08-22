package com.cortaYa.aplicacion.infraestructura.scheduler;

import com.cortaYa.aplicacion.dominio.model.Localidad;
import com.cortaYa.aplicacion.dominio.servicesImpl.LocalidadSyncService;
import com.cortaYa.aplicacion.infraestructura.api.ApiLocalidadClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LocalidadScheduler {

    private final LocalidadSyncService syncService;
    private final ApiLocalidadClient apiClient; // tu cliente para la API externa

    public LocalidadScheduler(LocalidadSyncService syncService, ApiLocalidadClient apiClient) {
        this.syncService = syncService;
        this.apiClient = apiClient;
    }

    @Scheduled(fixedRate = 24 * 60 * 60 * 1000) // cada 24h
    public void syncLocalidadesFromApi() {
        List<Localidad> localidadesApi = List.of(apiClient.obtenerLocalidades());
        syncService.syncLocalidades(localidadesApi);
    }
}