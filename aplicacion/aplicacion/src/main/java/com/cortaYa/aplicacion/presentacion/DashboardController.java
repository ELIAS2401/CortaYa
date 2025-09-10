package com.cortaYa.aplicacion.presentacion;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class DashboardController {

    @GetMapping("cliente/panel-cliente")
    public ModelAndView mostrarDashboard(ModelMap model) {
       
        return new ModelAndView("/cliente/dashboard-client");
    }
}