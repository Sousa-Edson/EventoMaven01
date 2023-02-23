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

    public Local Salvar(Local local) throws Exception {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            if (local.getId() == null) {
                em.persist(local); // executa inserir
            } else {
                if (!em.contains(local)) {
                    if (em.find(Local.class, local.getId()) == null) {
                        throw new Exception("Erro ao atualizar!!");
                    }
                }
                local = em.merge(local); // executa update
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return local;
    }

    public void remover(Long id) {
        EntityManager em = getEM();
        Local local = em.find(Local.class, id);
        try {
            em.getTransaction().begin();
            em.remove(local);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Local consultaPorId(Long id) {
        EntityManager em = getEM();
        Local l = null;
        try {
            l = em.find(Local.class, id);
        } finally {
            em.close();
        }
        return l;
    }
}
