package com.home.eventomaven01.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "palestrantre_seq", sequenceName = "palestrantre_seq", allocationSize = 1, initialValue = 1)
@NamedQueries({
    @NamedQuery(name = "Palestrante.consultaPorEvento",
            query = "SELECT pa FROM Palestrante pa "
            + " INNER JOIN pa.palestras p "
            + " WHERE p.evento.id = :eventoId "
            + " ORDER BY pa.nome asc")

})
public class Palestrante implements EntidadeBase{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "palestrantre_seq")
    private Long id;
    private String nome;
    @Column(name = "mini_bio")
    private String miniBio;

    @ManyToMany(mappedBy = "palestrantes", fetch = FetchType.EAGER)
    private List<Palestra> palestras;

    @Override
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

    public List<Palestra> getPalestras() {
        return palestras;
    }

    public void setPalestras(List<Palestra> palestras) {
        this.palestras = palestras;
    }

}
