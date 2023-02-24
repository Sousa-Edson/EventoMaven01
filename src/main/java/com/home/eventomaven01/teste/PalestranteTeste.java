package com.home.eventomaven01.teste;

import com.home.eventomaven01.dao.PalestranteDAO;
import com.home.eventomaven01.model.Palestrante;

public class PalestranteTeste {

    public static void main(String[] args) throws Exception {

        Palestrante pa = new Palestrante();
        pa.setNome("Joao Pedro");
        pa.setMiniBio("medico");

        Palestrante pa2 = new Palestrante();
        pa2.setNome("Joao Roberto");
        pa2.setMiniBio("dentista");


        PalestranteDAO dao = new PalestranteDAO();
        dao.salvar(pa);
        dao.salvar(pa2);
    }

}
