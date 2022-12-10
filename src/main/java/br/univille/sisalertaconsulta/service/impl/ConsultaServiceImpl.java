package br.univille.sisalertaconsulta.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.sisalertaconsulta.entity.Consulta;
import br.univille.sisalertaconsulta.service.ConsultaService;
import br.univille.sisalertaconsulta.repository.ConsultaRepository;

@Service
public class ConsultaServiceImpl implements ConsultaService {
    @Autowired
    private ConsultaRepository repositorio;

    @Override
    public List<Consulta> getAll() {
        return repositorio.findAll();
    }

    @Override
    public List<Consulta> getAllByDate() {
        return repositorio.findAllByDataAfterOrderByDataAsc(new Date());
    }

    @Override
    public Consulta save(Consulta consulta) {
        return repositorio.save(consulta);
    }
    
    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }

    @Override
    public Consulta findById(long id) {
        var resultado = repositorio.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        }
        return new Consulta();
    }
}
