package br.univille.sisalertaconsulta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

    private int contador;

    @GetMapping
    public ModelAndView index(){
        contador++;
        return new ModelAndView("/home/index","valor",contador);
    }
}
