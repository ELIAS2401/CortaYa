package com.cortaYa.aplicacion.dominio.services;

import com.cortaYa.aplicacion.dominio.dtos.UsuarioDTO;
import com.cortaYa.aplicacion.dominio.exceptions.EmailRegistradoException;
import com.cortaYa.aplicacion.dominio.model.Usuario;

import java.util.Optional;

public interface UsuarioService {
    void registrarCliente(UsuarioDTO usuarioDTO) throws Exception;

    void registrarBarbero(UsuarioDTO usuarioDTO) throws EmailRegistradoException, Exception;

    Optional<Usuario> obtenerUsuarioPorEmail(String email);
}
