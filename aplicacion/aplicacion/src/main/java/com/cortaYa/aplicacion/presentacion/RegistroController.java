package com.cortaYa.aplicacion.presentacion;


import com.cortaYa.aplicacion.dominio.model.Direccion;
import com.cortaYa.aplicacion.dominio.model.Localidad;
import com.cortaYa.aplicacion.dominio.model.Usuario;
import com.cortaYa.aplicacion.dominio.services.DireccionService;
import com.cortaYa.aplicacion.dominio.services.LocalidadService;
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

import java.util.List;

@Controller
public class RegistroController {

    private RegistroService registroService;
    private LocalidadService localidadService;
    private DireccionService direccionService;

    @Autowired
    public RegistroController(RegistroService registroService, LocalidadService localidadService, DireccionService direccionService) {
        this.registroService = registroService;
        this.localidadService = localidadService;
        this.direccionService = direccionService;
    }

    @RequestMapping("/registro")
    public ModelAndView viewRegistro() {
        ModelMap model = new ModelMap();
        model.addAttribute("usuario", new Usuario());
        List<Localidad> localidades = localidadService.obtenerLocalidades();
        model.addAttribute("localidades", localidades);
        return new ModelAndView("registro", model);
    }

    @PostMapping("/procesarRegistro")
    public String procesarRegistro(@ModelAttribute Usuario usuario, @RequestParam String rol,
                                   @RequestParam String calle,
                                   @RequestParam Long localidadId,
                                   @RequestParam Integer altura,
                                   @RequestParam Double direccionLat,
                                   @RequestParam Double direccionLon,
                                   @RequestParam(required = false) String localidadCP,
                                   Model model) {

                Localidad localidadCliente = localidadService.buscarLocalidad(localidadId);

        usuario.setLocalidad(localidadCliente);

        Direccion direccionCliente = direccionService.buscarDireccion(direccionLat, direccionLon);
        if (direccionCliente == null) {
            direccionCliente = new Direccion(calle, altura, localidadCliente);
            direccionService.registrarDireccion(direccionCliente);
        }
        usuario.setDireccion(direccionCliente);

        try {
            if ("Cliente".equalsIgnoreCase(rol)) {
                registroService.registrarCliente(usuario.getNombre(), usuario.getContrasenia(), usuario.getEmail(), usuario.getNroCelular(), usuario.getLocalidad(), usuario.getDireccion());
            } else if ("Barbero".equalsIgnoreCase(rol)) {
                registroService.registrarBarbero(usuario.getNombre(), usuario.getContrasenia(), usuario.getEmail(), usuario.getNroCelular(), usuario.getLocalidad(), usuario.getDireccion());
            }
            return "redirect:/login?RegistroSuccessful";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "registro";
        }
    }

}
