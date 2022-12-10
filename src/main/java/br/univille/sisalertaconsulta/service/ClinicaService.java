package br.univille.sisalertaconsulta.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.sisalertaconsulta.entity.Clinica;

@Service
public interface ClinicaService {
    List<Clinica> getAll();
    Clinica save(Clinica clinica);
}
