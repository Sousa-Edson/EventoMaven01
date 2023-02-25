package com.home.eventomaven01.dao;

import com.home.eventomaven01.model.Palestrante;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PalestranteDAO extends GenericoDAO<Palestrante> {

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
