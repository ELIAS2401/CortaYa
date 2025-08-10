package com.cortaYa.aplicacion.presentacion;


import com.cortaYa.aplicacion.dominio.model.Localidad;
import com.cortaYa.aplicacion.dominio.model.Usuario;
import com.cortaYa.aplicacion.dominio.services.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistroController {

    private RegistroService registroService;

    @Autowired
    public RegistroController(RegistroService registroService) {
        this.registroService = registroService;
    }

    @RequestMapping("/registro")
    public ModelAndView viewRegistro() {
        ModelMap model = new ModelMap();
        model.addAttribute("usuario", new Usuario());
        return new ModelAndView("registro", model);
    }

    @PostMapping("/procesarRegistro")
    public String procesarRegistro(@ModelAttribute Usuario usuario, @RequestParam String rol, @RequestParam String localidadName,  Model model) {
        Localidad newLocalidad = new Localidad(1L,localidadName,1403);
        usuario.setLocalidad(newLocalidad);
        try {
            if ("Cliente".equalsIgnoreCase(rol)) {
                registroService.registrarCliente(usuario.getNombre(), usuario.getContrasenia(), usuario.getEmail(), usuario.getNroCelular(), usuario.getLocalidad());
            } else if ("Barbero".equalsIgnoreCase(rol)){
                registroService.registrarBarbero(usuario.getNombre(), usuario.getContrasenia(), usuario.getEmail(), usuario.getNroCelular(), usuario.getLocalidad());
            }
            return "redirect:/login?RegistroSuccessful";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "registro";
        }
    }

}
