package com.cortaYa.aplicacion.presentacion;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public ModelAndView viewHome(){
        return new ModelAndView("home");
    }
    @GetMapping("/barbero/home")
    public ModelAndView viewHomeBarber(){
        return new ModelAndView("/barbero/home");
    }
    @RequestMapping("cliente/home")
    public ModelAndView viewHomeClient(){
        return new ModelAndView("/cliente/home");
    }


}
