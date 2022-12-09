package br.univille.sisalertaconsulta.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import br.univille.sisalertaconsulta.entity.Paciente;
import br.univille.sisalertaconsulta.repository.PacienteRepository;
import br.univille.sisalertaconsulta.service.PacienteService;

@Service
public class PacienteServiceImpl implements PacienteService {
    @Autowired
    private PacienteRepository repositorio;

    @Override
    public List<Paciente> getAll() {
        return repositorio.findAll();
    }

    @Override
    public Paciente save(Paciente paciente) {
        return repositorio.save(paciente);
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }

    @Override
    public Paciente findById(long id) {
        var resultado = repositorio.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        }
        return new Paciente();
    }
}