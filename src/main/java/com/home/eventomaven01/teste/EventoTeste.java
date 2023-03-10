package com.home.eventomaven01.teste;

import com.home.eventomaven01.dao.EventoDAO;
import com.home.eventomaven01.model.Evento;
import com.home.eventomaven01.model.Palestra;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class EventoTeste {

    public static void main(String[] args) throws Exception {
        DateFormat df = new SimpleDateFormat("dd/MM/yyy");
//
//        Palestra pa = new Palestra();
//        pa.setId(5L);
//
//        List<Palestra> palestras = new ArrayList<>();
//        palestras.add(pa);
//        Evento e = new Evento();
//        e.setNome("TESTE 0q");
//        e.setOrganizacao("EMPRESA A");
//        e.setInicio(df.parse("11/03/2023"));
//        e.setFim(df.parse("12/03/2023"));;
//        e.setPalestras(palestras);
        EventoDAO dao = new EventoDAO();
//        e = dao.salvar(e);
//        System.out.println("Evento " + e.getNome()+ " Salva");

//        dao.remover(p.getId());
//        Palestra p2 = dao.consultaPorId(2L);
//        System.out.println("Palestra " + p2.getTitulo() + " " + p2.getLocal().getPredio() + " " + p2.getLocal().getSala());
//        Palestra palestra = dao.consultaPorId(26L);
//        System.out.println("Palestra " + palestra.getTitulo());
//        for (Palestrante palestrante : palestra.getPalestrantes()) {
//            System.out.println("Palestrante " + palestrante.getNome());
//        }
//Consulta todos
        List<Evento> eventos = dao.consultarProximos();
        for (Evento e : eventos) {
            System.out.println(e.getNome() + " " + df.format(e.getInicio()) + " " + df.format(e.getFim()));
        }

    }

}
