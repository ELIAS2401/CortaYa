package com.cortaYa.aplicacion.presentacion;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClienteController {
    @GetMapping("/cliente/perfil-client")
    public ModelAndView mostrarPerfilCliente(ModelMap model) {

        return new ModelAndView("cliente/perfil-client");
    }
}
