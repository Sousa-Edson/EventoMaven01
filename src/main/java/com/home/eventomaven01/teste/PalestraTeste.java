package com.home.eventomaven01.teste;

import com.home.eventomaven01.dao.PalestraDAO;
import com.home.eventomaven01.model.Local;
import com.home.eventomaven01.model.Palestra;
import com.home.eventomaven01.model.Palestrante;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PalestraTeste {
    
    public static void main(String[] args) throws Exception {
        DateFormat df = new SimpleDateFormat("dd/MM/yyy HH:mm");
        
        Palestrante pa = new Palestrante();
        pa.setNome("David Gabriel");
        pa.setMiniBio("estudante");
        
        List<Palestrante> palestrantes = new ArrayList<>();
        palestrantes.add(pa);
        
        Local l = new Local();
//        l.setPredio("Delta");
//        l.setSala("D123");
//        l.setCapacidade(60);
        l.setId(12L);
        
        Palestra p = new Palestra();
        p.setTitulo("OneToMany e ManyToOne com JPA");
        p.setLocal(l);
        p.setDuracao(100);
        p.setDataHora(df.parse("26/09/2023 21:00"));
        p.setPalestrantes(palestrantes);
        pa.setPalestra(p);
//
        PalestraDAO dao = new PalestraDAO();
        p = dao.salvar(p);
        System.out.println("Palestra " + p.getTitulo() + " Salva");

//        dao.remover(p.getId());
//        Palestra p2 = dao.consultaPorId(2L);
//        System.out.println("Palestra " + p2.getTitulo() + " " + p2.getLocal().getPredio() + " " + p2.getLocal().getSala());
    }
    
}
