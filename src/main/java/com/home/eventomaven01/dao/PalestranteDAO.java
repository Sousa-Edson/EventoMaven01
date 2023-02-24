package com.home.eventomaven01.dao;

import com.home.eventomaven01.model.Palestrante;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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

    public List<Palestrante> consultaPorEvento(Long eventoId) {
        EntityManager em = getEM();
        List<Palestrante> palestrantes;
        try {
            Query q = em.createNamedQuery("Palestrante.consultaPorEvento");
            q.setParameter("eventoId", eventoId);
            palestrantes = q.getResultList();
        } catch (Exception e) {
            palestrantes = new ArrayList();
        } finally {
            em.close();
        }
        return palestrantes;
    }

}
