package com.cortaYa.aplicacion.presentacion;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public ModelAndView mostrarLogin(){
        ModelMap model = new ModelMap();
        String parrafo = "hola mundillo";
        model.addAttribute("holaMundo",parrafo);
        return new ModelAndView("login",model);
    }

    @GetMapping("/hola")
    @ResponseBody
    public String helloWord(){
        return "Serielize";
    }
    @GetMapping("chau")
    @ResponseBody
    public String chayMundo(){
        return "Adios mundo";
    }

}
