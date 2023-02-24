package com.home.eventomaven01.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "palestrantre_seq", sequenceName = "palestrantre_seq", allocationSize = 1, initialValue = 1)
public class Palestrante {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "palestrantre_seq")
    private Long id;
    private String nome;
    @Column(name = "mini_bio")
    private String miniBio;

//    @JoinColumn(name = "palestra_id")
//    @ManyToOne
//    private Palestra palestra;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMiniBio() {
        return miniBio;
    }

    public void setMiniBio(String miniBio) {
        this.miniBio = miniBio;
    }

}
