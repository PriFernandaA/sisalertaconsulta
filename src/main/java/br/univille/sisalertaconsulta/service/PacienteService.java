package br.univille.sisalertaconsulta.service;

import org.springframework.stereotype.Service;

import java.util.List;
import br.univille.sisalertaconsulta.entity.Paciente;

@Service
public interface PacienteService {
    List<Paciente> getAll();
    Paciente save(Paciente paciente);
    Paciente findById(long id);
    void delete(long id);
}
