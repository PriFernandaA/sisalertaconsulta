package br.univille.sisalertaconsulta.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
public class Medico extends Pessoa {
    @Column(length = 100)
    private String especialidade;
    @OneToOne (cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    
    public String getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
