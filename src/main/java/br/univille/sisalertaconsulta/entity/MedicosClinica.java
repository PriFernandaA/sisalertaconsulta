package br.univille.sisalertaconsulta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class MedicosClinica {
    @ManyToOne()
    private Clinica clinica;
    @ManyToOne()
    private Medico medico;
    @Column(columnDefinition = "tinyint(1) default 1")
    private boolean ativo;

    public Clinica getClinica() {
        return clinica;
    }
    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }
    public Medico getMedico() {
        return medico;
    }
    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    public boolean isAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
