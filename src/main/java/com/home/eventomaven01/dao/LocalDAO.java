package com.home.eventomaven01.dao;

import com.home.eventomaven01.model.Local;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LocalDAO {

    public EntityManager getEM() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev-up");
        return factory.createEntityManager();
    }

    public Local Salvar(Local local) {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            em.persist(local); //inserir
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return local;
    }
}
