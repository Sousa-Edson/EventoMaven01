package com.home.eventomaven01.dao;

import com.home.eventomaven01.model.Evento;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
}
