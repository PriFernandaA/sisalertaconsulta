package br.univille.sisalertaconsulta.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.univille.sisalertaconsulta.entity.Exame;

@Repository
public interface ExameRepository  extends JpaRepository<Exame,Long>{
    List<Exame> findAllByDataAfterOrderByDataAsc(@Param("data") Date data);    
}
