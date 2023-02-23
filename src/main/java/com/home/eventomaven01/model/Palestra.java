package com.home.eventomaven01.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name = "palestra_seq", sequenceName = "palestra_seq", allocationSize = 1, initialValue = 1)
public class Palestra {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "palestra_seq")
    private Long id;
    private String titulo;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;
    private int duracao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

}
