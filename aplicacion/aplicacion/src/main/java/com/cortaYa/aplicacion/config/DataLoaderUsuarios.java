package com.cortaYa.aplicacion.config;

import com.cortaYa.aplicacion.dominio.enums.RolEnum;
import com.cortaYa.aplicacion.dominio.model.UsuarioBarber;
import com.cortaYa.aplicacion.dominio.model.UsuarioCliente;
import com.cortaYa.aplicacion.dominio.repositories.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoaderUsuarios {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder; // para guardar el pass encriptado

    @PostConstruct
    public void precargarUsuarios() {
        if (usuarioRepository.count() == 0) {
            // Usuario cliente
            UsuarioCliente cliente = new UsuarioCliente();
            cliente.setNombre("Juan Cliente");
            cliente.setEmail("cliente@cortaya.com");
            cliente.setContrasenia(passwordEncoder.encode("c123"));
            cliente.setRol(RolEnum.ROLE_CLIENTE);

            // Usuario barbero
            UsuarioBarber barbero = new UsuarioBarber();
            barbero.setNombre("Pedro Barbero");
            barbero.setEmail("barbero@cortaya.com");
            barbero.setContrasenia(passwordEncoder.encode("b123"));
            barbero.setRol(RolEnum.ROLE_BARBERO);

            usuarioRepository.save(cliente);
            usuarioRepository.save(barbero);

            System.out.println("Usuarios precargados: cliente y barbero");
        }
    }
}
