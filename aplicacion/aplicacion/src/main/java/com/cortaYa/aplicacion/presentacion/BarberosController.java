package com.cortaYa.aplicacion.presentacion;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.cortaYa.aplicacion.modelo.Barbero;

import java.util.Arrays;
import java.util.List;



@Controller
public class BarberosController {

    @GetMapping("/barberos-disponibles")
    public String mostrarDashboard(ModelMap model) {
        List<Barbero> barberos = Arrays.asList(
            new Barbero("Carlos", 5, "/images/barberos/carlos.png"),
            new Barbero("Juan", 4, "/images/barberos/juan.png"),
            new Barbero("Pedro", 3, "/images/barberos/pedro.png"),
            new Barbero("Lucía", 5, "/images/barberos/lucia.png"),
            new Barbero("Victor", 5, "/images/barberos/Victor.png")
        );

        model.addAttribute("barberos", barberos);

        return "barbers-availables"; 
    }
}