package br.univille.sisalertaconsulta.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Receita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Consulta consulta;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expiracao;
    @Column(length = 20)
    private String periodoRenovacaoString;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Consulta getConsulta() {
        return consulta;
    }
    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public Date getExpiracao() {
        return expiracao;
    }
    public void setExpiracao(Date expiracao) {
        this.expiracao = expiracao;
    }
    public String getPeriodoRenovacaoString() {
        return periodoRenovacaoString;
    }
    public void setPeriodoRenovacaoString(String periodoRenovacaoString) {
        this.periodoRenovacaoString = periodoRenovacaoString;
    }
}
