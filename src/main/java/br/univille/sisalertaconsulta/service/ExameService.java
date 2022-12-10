package br.univille.sisalertaconsulta.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.sisalertaconsulta.entity.Exame;

@Service
public interface ExameService {
    List<Exame> getAll();
    Exame save(Exame exame);
    Exame findById(long id);
    void delete(long id);
}
