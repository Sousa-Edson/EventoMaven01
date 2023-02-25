package com.home.eventomaven01.dao;

import com.home.eventomaven01.model.Evento;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class EventoDAO extends GenericoDAO<Evento> {

    
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
     public List<Evento> consultarProximos() {
        EntityManager em = getEM();
        List<Evento> eventos;
        try {
            Query q = em.createNamedQuery("Evento.consultaProximos");
            eventos = q.getResultList();  
        } catch (Exception e) {
            eventos = new ArrayList();
        } finally {
            em.close();
        }
        return eventos;
    }
}
