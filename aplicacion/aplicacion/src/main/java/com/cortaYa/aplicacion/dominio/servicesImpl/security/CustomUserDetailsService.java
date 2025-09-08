package com.cortaYa.aplicacion.dominio.servicesImpl.security;

import com.cortaYa.aplicacion.dominio.model.Usuario;
import com.cortaYa.aplicacion.dominio.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        return org.springframework.security.core.userdetails.User.builder()
                .username(usuario.getEmail())
                .password(usuario.getContrasenia()) // ya está encriptada
                .roles(usuario.getRol().name().replace("ROLE_", "")) // ej: "CLIENTE" o "BARBERO"
                .build();
    }
}
