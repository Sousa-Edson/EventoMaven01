package com.home.eventomaven01.dao;

import com.home.eventomaven01.model.Palestra;
import com.home.eventomaven01.model.Palestrante;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PalestranteDAO {

    public EntityManager getEM() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev-up");
        return factory.createEntityManager();
    }

    public Palestrante salvar(Palestrante palestrante) throws Exception {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            em.persist(palestrante); // executa insert
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return palestrante;
    }

    public void remover(Long id) {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            Palestrante p = em.find(Palestrante.class, id);
            em.remove(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Palestrante consultaPorId(Long id) {
        EntityManager em = getEM();
        Palestrante p = null;
        try {
            p = em.find(Palestrante.class, id);
        } finally {
            em.close();
        }
        return p;
    }
}
