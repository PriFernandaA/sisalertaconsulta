package br.univille.sisalertaconsulta.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.sisalertaconsulta.entity.Clinica;
import br.univille.sisalertaconsulta.entity.Exame;
import br.univille.sisalertaconsulta.entity.Paciente;
import br.univille.sisalertaconsulta.service.ClinicaService;
import br.univille.sisalertaconsulta.service.ExameService;
import br.univille.sisalertaconsulta.service.PacienteService;

@Controller
@RequestMapping("/exames")
public class ExameController {
    @Autowired
    private ExameService service;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private ClinicaService clinicaService;

    @GetMapping
    public ModelAndView index() {
        var listaExames = service.getAll();

        return new ModelAndView("/exames/index", "listaExames", listaExames);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var exame = new Exame();
        var clinica = new Clinica();
        var paciente = new Paciente();
        var listaClinicas = clinicaService.getAll();
        var listaPacientes = pacienteService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("exame", exame);
        dados.put("clinica", clinica);
        dados.put("paciente", paciente);
        dados.put("listaClinicas",listaClinicas);
        dados.put("listaPacientes",listaPacientes);
        
        return new ModelAndView("exames/form", dados);
    }

    @PostMapping(params = "form")
    public ModelAndView save(Exame exame){
        service.save(exame);
        
        return new ModelAndView("redirect:/exames");
    }

    @PostMapping("/clinica/add")
    public ResponseEntity<Clinica> save(Clinica clinica){
        clinicaService.save(clinica);

        return new ResponseEntity<>(clinica, HttpStatus.CREATED);
    }

    @PostMapping("/paciente/add")
    public ResponseEntity<Paciente> save(Paciente paciente){
        pacienteService.save(paciente);

        return new ResponseEntity<>(paciente, HttpStatus.CREATED);
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var exame = service.findById(id);
        var paciente = new Paciente();
        var clinica = new Clinica();
        var listaPacientes = pacienteService.getAll();
        var listaClinicas = clinicaService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("paciente", paciente);
        dados.put("clinica", clinica);
        dados.put("listaPacientes", listaPacientes);
        dados.put("listaClinicas", listaClinicas);
        dados.put("exame", exame);
        
        return new ModelAndView("exames/form", dados);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){

        service.delete(id);

        return new ModelAndView("redirect:/exames");
    }
}
