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
import br.univille.sisalertaconsulta.entity.Consulta;
import br.univille.sisalertaconsulta.entity.Medico;
import br.univille.sisalertaconsulta.entity.Paciente;
import br.univille.sisalertaconsulta.service.ClinicaService;
import br.univille.sisalertaconsulta.service.ConsultaService;
import br.univille.sisalertaconsulta.service.MedicoService;
import br.univille.sisalertaconsulta.service.PacienteService;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {
    @Autowired
    private ConsultaService service;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private ClinicaService clinicaService;

    @GetMapping
    public ModelAndView index() {
        var listaConsultas = service.getAll();

        return new ModelAndView("/consultas/index", "listaConsultas", listaConsultas);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var consulta = new Consulta();
        var paciente = new Paciente();
        var medico = new Medico();
        var clinica = new Clinica();
        var listaPacientes = pacienteService.getAll();
        var listaMedicos = medicoService.getAll();
        var listaClinicas = clinicaService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("consulta", consulta);
        dados.put("paciente", paciente);
        dados.put("medico", medico);
        dados.put("clinica", clinica);
        dados.put("listaPacientes", listaPacientes);
        dados.put("listaMedicos", listaMedicos);
        dados.put("listaClinicas",listaClinicas);
        
        return new ModelAndView("consultas/form", dados);
    }

    @PostMapping(params = "form")
    public ModelAndView save(Consulta consulta){
        service.save(consulta);
        
        return new ModelAndView("redirect:/consultas");
    }
    
    @PostMapping("/paciente/add")
    public ResponseEntity<Paciente> save(Paciente paciente){
        pacienteService.save(paciente);

        return new ResponseEntity<>(paciente, HttpStatus.CREATED);
    }
    
    @PostMapping("/medico/add")
    public ResponseEntity<Medico> save(Medico medico){
        medicoService.save(medico);

        return new ResponseEntity<>(medico, HttpStatus.CREATED);
    }

    @PostMapping("/clinica/add")
    public ResponseEntity<Clinica> save(Clinica clinica){
        clinicaService.save(clinica);

        return new ResponseEntity<>(clinica, HttpStatus.CREATED);
    }
    
    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var consulta = service.findById(id);
        var paciente = new Paciente();
        var medico = new Medico();
        var clinica = new Clinica();
        var listaPacientes = pacienteService.getAll();
        var listaMedicos = medicoService.getAll();
        var listaClinicas = clinicaService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("paciente", paciente);
        dados.put("medico", medico);
        dados.put("clinica", clinica);
        dados.put("listaPacientes", listaPacientes);
        dados.put("listaMedicos", listaMedicos);
        dados.put("listaClinicas", listaClinicas);
        dados.put("consulta", consulta);
        
        return new ModelAndView("consultas/form", dados);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){

        service.delete(id);

        return new ModelAndView("redirect:/consultas");
    }
}
