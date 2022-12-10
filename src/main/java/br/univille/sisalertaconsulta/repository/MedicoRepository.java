package br.univille.sisalertaconsulta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.sisalertaconsulta.entity.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    
}
