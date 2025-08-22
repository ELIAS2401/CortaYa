package com.cortaYa.aplicacion.dominio.servicesImpl;

import com.cortaYa.aplicacion.dominio.model.Localidad;
import com.cortaYa.aplicacion.dominio.repositories.LocalidadRepository;
import com.cortaYa.aplicacion.dominio.services.LocalidadService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class LocalidadServiceImpl implements LocalidadService {
    private final LocalidadRepository localidadRepository;

    public LocalidadServiceImpl(LocalidadRepository localidadRepository){
        this.localidadRepository=localidadRepository;
    }


    @Override
    public Localidad buscarLocalidad(Long id) {
        return null;
    }

    @Override
    public void registrarLocalidad(Localidad localidadCliente) {
        this.localidadRepository.save(localidadCliente);
    }

    @Override
    public List<Localidad> obtenerLocalidades() {
        return localidadRepository.findAll();
    }

    public Optional<Localidad> buscarPorNombreYCodigoPostal(String nombre, String codigoPostal) {
        return localidadRepository.findByNombreAndCodigoPostal(nombre, codigoPostal);
    }
}
