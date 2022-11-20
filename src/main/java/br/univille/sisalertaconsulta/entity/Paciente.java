package br.univille.sisalertaconsulta.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
public class Paciente extends Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(columnDefinition = "tinyint(1) default 1")
    private boolean planoSaude;
    @OneToOne (cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    private Pessoa pessoa;
    
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public boolean isPlanoSaude() {
        return planoSaude;
    }
    public void setPlanoSaude(boolean planoSaude) {
        this.planoSaude = planoSaude;
    }
    public Pessoa getPessoa() {
        return pessoa;
    }
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }   
}
