package br.univille.sisalertaconsulta.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.sisalertaconsulta.entity.Consulta;

@Service
public interface ConsultaService {
    List<Consulta> getAll();
    Consulta save(Consulta consulta);
    Consulta findById(long id);
    void delete(long id);
}
