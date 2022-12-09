package br.univille.sisalertaconsulta.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.sisalertaconsulta.entity.Paciente;
import br.univille.sisalertaconsulta.service.PacienteService;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {
    
    @Autowired
    private PacienteService service;

    @GetMapping
    public ModelAndView index(){

        var listaPacientes = service.getAll();

        return new ModelAndView("pacientes/index", "listaPacientes", listaPacientes);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var novoPaciente = new Paciente();
        
        return new ModelAndView("pacientes/form","paciente",novoPaciente);
    }

    @PostMapping(params = "form")
    public ModelAndView save(Paciente paciente){
        service.save(paciente);
        
        return new ModelAndView("redirect:/pacientes");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        
        var umPaciente = service.findById(id);
        return new ModelAndView("pacientes/form","paciente",umPaciente);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){

        service.delete(id);

        return new ModelAndView("redirect:/pacientes");
    }
}
