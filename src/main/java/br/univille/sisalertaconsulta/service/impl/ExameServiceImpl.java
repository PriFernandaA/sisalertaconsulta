package br.univille.sisalertaconsulta.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.sisalertaconsulta.entity.Exame;
import br.univille.sisalertaconsulta.repository.ExameRepository;
import br.univille.sisalertaconsulta.service.ExameService;

@Service
public class ExameServiceImpl implements ExameService{
    @Autowired
    private ExameRepository repositorio;

    @Override
    public List<Exame> getAll() {
        return repositorio.findAll();
    }

    @Override
    public List<Exame> getAllByDate() {
        return repositorio.findAllByDataAfterOrderByDataAsc(new Date());
    }

    @Override
    public Exame save(Exame exame) {
        return repositorio.save(exame);
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }

    @Override
    public Exame findById(long id) {
        var resultado = repositorio.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        }
        return new Exame();
    }
}
    

