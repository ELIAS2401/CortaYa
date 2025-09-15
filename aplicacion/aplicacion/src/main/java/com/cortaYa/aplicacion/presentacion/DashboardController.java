package com.cortaYa.aplicacion.presentacion;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class DashboardController {

    @GetMapping("/panel-cliente")
    public String mostrarDashboard(ModelMap model) {
       
        return "dashboard-client"; 
    }
}