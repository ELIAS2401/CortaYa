package com.cortaYa.aplicacion.dominio.servicesImpl;

import com.cortaYa.aplicacion.dominio.dtos.UsuarioDTO;
import com.cortaYa.aplicacion.dominio.exceptions.EmailRegistradoException;
import com.cortaYa.aplicacion.dominio.model.*;
import com.cortaYa.aplicacion.dominio.repositories.UsuarioRepository;
import com.cortaYa.aplicacion.dominio.services.DireccionService;
import com.cortaYa.aplicacion.dominio.services.LocalidadService;
import com.cortaYa.aplicacion.dominio.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final LocalidadService localidadService;
    private final DireccionService direccionService;

    @Override
    public void registrarCliente(UsuarioDTO usuarioDTO) throws Exception {

        Direccion direccion = direccionService.crearNuevaDireccion(usuarioDTO.getCalleAltura(), usuarioDTO.getIdLocalidad());

        Usuario cliente= UsuarioCliente.builder()
                .nombre(usuarioDTO.getNombre())
                .email(usuarioDTO.getEmail())
                .nroCelular(usuarioDTO.getNroCelular())
                .contrasenia(usuarioDTO.getContrasenia())
                .direccion(direccion)
                .build();

        if (usuarioRepository.findByEmail(cliente.getEmail()).isPresent()) {
            throw new EmailRegistradoException("El email ya está registrado.");
        }

        usuarioRepository.save(cliente);
    }

    @Override
    public void registrarBarbero(UsuarioDTO usuarioDTO) throws EmailRegistradoException{
        Direccion direccion = direccionService.crearNuevaDireccion(usuarioDTO.getCalleAltura(), usuarioDTO.getIdLocalidad());

        Usuario cliente= UsuarioBarber.builder()
                .nombre(usuarioDTO.getNombre())
                .email(usuarioDTO.getEmail())
                .nroCelular(usuarioDTO.getNroCelular())
                .contrasenia(usuarioDTO.getContrasenia())
                .direccion(direccion)
                .build();

        if (usuarioRepository.findByEmail(cliente.getEmail()).isPresent()) {
            throw new EmailRegistradoException("El email ya está registrado.");
        }

        usuarioRepository.save(cliente);
    }
}
