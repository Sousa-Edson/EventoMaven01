package com.home.eventomaven01.teste;

import com.home.eventomaven01.dao.PalestraDAO;
import com.home.eventomaven01.model.Local;
import com.home.eventomaven01.model.Palestra;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class PalestraTeste {

    public static void main(String[] args) throws Exception {
        DateFormat df = new SimpleDateFormat("dd/MM/yyy HH:mm");
//        Local l = new Local();
//        l.setPredio("Delta");
//        l.setSala("D123");
//        l.setCapacidade(60);
//
//        Palestra p = new Palestra();
//        p.setTitulo("Relacionamento com JPA");
//        p.setLocal(l);
//        p.setDuracao(100);
//        p.setDataHora(df.parse("26/09/2023 19:00"));
//
        PalestraDAO dao = new PalestraDAO();
//        p = dao.salvar(p);
//        System.out.println("Palestra " + p.getTitulo() + " Salva");
//
//        dao.remover(p.getId());
Palestra p2 = dao.consultaPorId(2L);
        System.out.println("Palestra "+p2.getTitulo()+" "+p2.getLocal().getPredio()+" "+p2.getLocal().getSala());

    }

}
