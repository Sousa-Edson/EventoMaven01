package com.home.eventomaven01.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name = "palestra_seq", sequenceName = "palestra_seq", allocationSize = 1, initialValue = 1)
@NamedQueries({
        @NamedQuery(name = "Palestra.consultaPorEvento",
                query = "SELECT p FROM Palestra p WHERE p.evento.id = :eventoId")
        
})
public class Palestra {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "palestra_seq")
    private Long id;
    private String titulo;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_hora")
    private Date dataHora;
    private int duracao;

    @OneToOne   // tirando a operação em caacata
    private Local local;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Palestra_Palestrante",
            joinColumns = @JoinColumn(name = "palestra_id"),
            inverseJoinColumns = @JoinColumn(name = "palestrante_id"))
    private List<Palestrante> palestrantes;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

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

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public List<Palestrante> getPalestrantes() {
        return palestrantes;
    }

    public void setPalestrantes(List<Palestrante> palestrantes) {
        this.palestrantes = palestrantes;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

}
