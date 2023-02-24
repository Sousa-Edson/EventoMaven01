package com.home.eventomaven01.dao;

import com.home.eventomaven01.model.Palestra;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PalestraDAO {

    public EntityManager getEM() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev-up");
        return factory.createEntityManager();
    }

    public Palestra salvar(Palestra palestra) throws Exception {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            em.persist(palestra); // executa insert
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return palestra;
    }

    public void remover(Long id) {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            Palestra p = em.find(Palestra.class, id);
            em.remove(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Palestra consultaPorId(Long id) {
        EntityManager em = getEM();
        Palestra p = null;
        try {
            p = em.find(Palestra.class, id);
        } finally {
            em.close();
        }
        return p;
    }
}
