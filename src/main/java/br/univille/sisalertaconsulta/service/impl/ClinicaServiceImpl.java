package br.univille.sisalertaconsulta.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.sisalertaconsulta.entity.Clinica;
import br.univille.sisalertaconsulta.repository.ClinicaRepository;
import br.univille.sisalertaconsulta.service.ClinicaService;

@Service
public class ClinicaServiceImpl implements ClinicaService {
    @Autowired
    private ClinicaRepository repositorio;

    @Override
    public List<Clinica> getAll() {
        return repositorio.findAll();
    }

    @Override
    public Clinica save(Clinica clinica) {
        return repositorio.save(clinica);
    }
}

