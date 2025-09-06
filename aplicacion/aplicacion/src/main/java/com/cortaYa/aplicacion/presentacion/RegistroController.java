package com.cortaYa.aplicacion.presentacion;

import com.cortaYa.aplicacion.dominio.dtos.UsuarioDTO;
import com.cortaYa.aplicacion.dominio.exceptions.EmailRegistradoException;
import com.cortaYa.aplicacion.dominio.model.*;
import com.cortaYa.aplicacion.dominio.services.DireccionService;
import com.cortaYa.aplicacion.dominio.services.LocalidadService;
import com.cortaYa.aplicacion.dominio.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class RegistroController {

    private LocalidadService localidadService;
    private DireccionService direccionService;
    private UsuarioService usuarioService;

    @RequestMapping("/registro")
    public ModelAndView viewRegistro() {
        ModelMap model = new ModelMap();
        model.addAttribute("usuarioDTO", new UsuarioDTO());
        return new ModelAndView("registro", model);
    }

    @PostMapping("/procesarRegistro")
    public String procesarRegistro(@ModelAttribute UsuarioDTO usuarioDTO, Model model) {

        System.out.println("usuario dto: " + usuarioDTO);

        try {
            if ("Cliente".equalsIgnoreCase(usuarioDTO.getRol())) {
                usuarioService.registrarCliente(usuarioDTO);
            } else if ("Barbero".equalsIgnoreCase(usuarioDTO.getRol())) {
                usuarioService.registrarBarbero(usuarioDTO);
            }
            return "redirect:/login?RegistroSuccessful";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "registro";
        }
    }

}
