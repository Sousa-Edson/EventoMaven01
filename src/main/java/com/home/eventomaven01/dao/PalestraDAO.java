package com.home.eventomaven01.dao;

import com.home.eventomaven01.model.Palestra;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PalestraDAO extends GenericoDAO<Palestra>  {
 

    public List<Palestra> consultaPorEvento(Long eventoId) {
        EntityManager em = getEM();
        List<Palestra> palestras;
        try {
            Query q = em.createNamedQuery("Palestra.consultaPorEvento");
            q.setParameter("eventoId", eventoId);
            palestras = q.getResultList();
        } catch (Exception e) {
            palestras = new ArrayList();
        } finally {
            em.close();
        }
        return palestras;
    }
}
