package br.univille.sisalertaconsulta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
public class Paciente extends Pessoa {
    @Column(columnDefinition = "tinyint(1) default 1")
    private boolean planoSaude;
    
    public boolean isPlanoSaude() {
        return planoSaude;
    }
    public void setPlanoSaude(boolean planoSaude) {
        this.planoSaude = planoSaude;
    }
}
