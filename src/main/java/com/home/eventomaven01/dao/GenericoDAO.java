package com.home.eventomaven01.dao;

import com.home.eventomaven01.model.EntidadeBase;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericoDAO< T extends EntidadeBase> {

    public EntityManager getEM() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev-up");
        return factory.createEntityManager();
    }

    public T Salvar(T t) throws Exception {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            if (t.getId() == null) {
                em.persist(t); // executa inserir
            } else {
                if (!em.contains(t)) {
                    if (em.find(t.getClass(), t.getId()) == null) {
                        throw new Exception("Erro ao atualizar!!");
                    }
                }
                t = em.merge(t); // executa update
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return t;
    }

    public void remover(Class<T> clazz, Long id) {
        EntityManager em = getEM();
        T t = em.find(clazz, id);
        try {
            em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public T consultaPorId(Class<T> clazz, Long id) {
        EntityManager em = getEM();
        T t = null;
        try {
            t = em.find(clazz, id);
        } finally {
            em.close();
        }
        return t;
    }
}
