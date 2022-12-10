package br.univille.sisalertaconsulta.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.sisalertaconsulta.entity.Medico;

@Service
public interface MedicoService {
    List<Medico> getAll();
    Medico save(Medico medico);
}
