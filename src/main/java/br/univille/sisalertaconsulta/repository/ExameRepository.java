package br.univille.sisalertaconsulta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.sisalertaconsulta.entity.Exame;

@Repository
public interface ExameRepository  extends JpaRepository<Exame,Long>{

    
}
