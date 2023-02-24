package com.home.eventomaven01.dao;

import com.home.eventomaven01.model.Evento;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EventoDAO {

    public EntityManager getEM() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev-up");
        return factory.createEntityManager();
    }

    public Evento salvar(Evento evento) throws Exception {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            em.persist(evento); // executa insert
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return evento;
    }

    public void remover(Long id) {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            Evento e = em.find(Evento.class, id);
            em.remove(e);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Evento consultaPorId(Long id) {
        EntityManager em = getEM();
        Evento e = null;
        try {
            e = em.find(Evento.class, id);
        } finally {
            em.close();
        }
        return e;
    }

    public List<Evento> consultarTodos() {
        EntityManager em = getEM();
        List<Evento> eventos;
        try {
            Query q = em.createNamedQuery("Evento.consultaTodos");

            eventos = q.getResultList(); // para uma lista de registro
//        q.getSingleResult();// para apenas um registro
        } catch (Exception e) {
            eventos = new ArrayList();
        } finally {
            em.close();
        }
        return eventos;
    }
}
