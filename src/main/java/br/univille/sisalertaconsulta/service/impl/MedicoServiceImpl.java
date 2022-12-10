package br.univille.sisalertaconsulta.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.sisalertaconsulta.entity.Medico;
import br.univille.sisalertaconsulta.repository.MedicoRepository;
import br.univille.sisalertaconsulta.service.MedicoService;

@Service
public class MedicoServiceImpl implements MedicoService {
    @Autowired
    private MedicoRepository repositorio;

    @Override
    public List<Medico> getAll() {
        return repositorio.findAll();
    }

    @Override
    public Medico save(Medico medico) {
        return repositorio.save(medico);
    }
}
