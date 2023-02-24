package com.home.eventomaven01.teste;

import com.home.eventomaven01.dao.PalestranteDAO;
import com.home.eventomaven01.model.Palestra;
import com.home.eventomaven01.model.Palestrante;
import java.util.List;

public class PalestranteTeste {

    public static void main(String[] args) throws Exception {

//        Palestrante pa = new Palestrante();
//        pa.setNome("Joao Pedro");
//        pa.setMiniBio("medico");
//
//        Palestrante pa2 = new Palestrante();
//        pa2.setNome("Joao Roberto");
//        pa2.setMiniBio("dentista");
        PalestranteDAO dao = new PalestranteDAO();
//        dao.salvar(pa);
//        dao.salvar(pa2);

//        Palestrante palestrante = dao.consultaPorId(6L);
//        System.out.println("Palestrante " + palestrante.getNome());
//        for (Palestra p : palestrante.getPalestras()) {
//            System.out.println("Palestra " + p.getTitulo() + " no " + p.getLocal().getPredio() + " - " + p.getLocal().getSala());
//        }
        List<Palestrante> palestrantes = dao.consultaPorEvento(1L);
        for (Palestrante p : palestrantes) {
            System.out.println(p.getNome());
        }
    }
}
