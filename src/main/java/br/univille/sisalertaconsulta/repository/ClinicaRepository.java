package br.univille.sisalertaconsulta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.sisalertaconsulta.entity.Clinica;

@Repository
public interface ClinicaRepository extends JpaRepository<Clinica, Long> {
    
}