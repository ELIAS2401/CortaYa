package com.cortaYa.aplicacion.presentacion;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public ModelAndView viewHome(){
        return new ModelAndView("home");
    }
    @RequestMapping("/homeBarber")
    public ModelAndView viewHomeBarber(){
        return new ModelAndView("homeBarber");
    }
    @RequestMapping("/homeClient")
    public ModelAndView viewHomeClient(){
        return new ModelAndView("homeClient");
    }


}
