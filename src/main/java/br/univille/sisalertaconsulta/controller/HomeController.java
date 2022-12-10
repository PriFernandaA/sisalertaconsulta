package br.univille.sisalertaconsulta.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.sisalertaconsulta.service.ConsultaService;
import br.univille.sisalertaconsulta.service.ExameService;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private ConsultaService consultaService;

    @Autowired
    private ExameService exameService;

    @GetMapping
    public ModelAndView index(){
        var listaConsultas = consultaService.getAllByDate();
        var listaExames = exameService.getAllByDate();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("listaConsultas", listaConsultas);
        dados.put("listaExames",listaExames);

        return new ModelAndView("/home/index", dados);
    }
}
