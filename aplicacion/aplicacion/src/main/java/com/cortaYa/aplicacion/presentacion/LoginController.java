package com.cortaYa.aplicacion.presentacion;

import com.cortaYa.aplicacion.dominio.model.Usuario;
import com.cortaYa.aplicacion.dominio.repositories.UsuarioRepository;
import com.cortaYa.aplicacion.dominio.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class LoginController {

    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";
    }

    @GetMapping("/default")
    public String defaultAfterLogin(Authentication auth) {
        if (auth.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_BARBERO"))) {
            return "redirect:/barbero/home";
        }
        return "redirect:/cliente/home";
    }
}
