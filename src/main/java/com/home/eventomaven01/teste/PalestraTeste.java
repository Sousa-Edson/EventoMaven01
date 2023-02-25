package com.home.eventomaven01.teste;

import com.home.eventomaven01.dao.PalestraDAO;
import com.home.eventomaven01.model.Palestra;
import com.home.eventomaven01.model.Palestrante;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class PalestraTeste {

    public static void main(String[] args) throws Exception {
        DateFormat df = new SimpleDateFormat("dd/MM/yyy HH:mm");

//        Palestrante pa = new Palestrante();
//        pa.setId(5L);
//       
//        Palestrante pa2 = new Palestrante();
//        pa2.setId(7L);
//
//        List<Palestrante> palestrantes = new ArrayList<>();
//        palestrantes.add(pa);
//         palestrantes.add(pa2);
//
//        Local l = new Local();
//        l.setId(12L);
//
//        Palestra p = new Palestra();
//        p.setTitulo("Festa na piscina 3");
//        p.setLocal(l);
//        p.setDuracao(6);
//        p.setDataHora(df.parse("03/10/2023 21:00"));
//
//        p.setPalestrantes(palestrantes);
        PalestraDAO dao = new PalestraDAO();
//        p = dao.salvar(p);
//        System.out.println("Palestra " + p.getTitulo() + " Salva");

//        dao.remover(p.getId());
//        Palestra p2 = dao.consultaPorId(2L);
//        System.out.println("Palestra " + p2.getTitulo() + " " + p2.getLocal().getPredio() + " " + p2.getLocal().getSala());
//        Palestra palestra = dao.consultaPorId(26L);
//        System.out.println("Palestra " + palestra.getTitulo());
//        for (Palestrante palestrante : palestra.getPalestrantes()) {
//            System.out.println("Palestrante " + palestrante.getNome());
//        }
//consulta nomeada
       List<Palestra> palestras =  dao.consultaPorEvento(1L);
       
       for(Palestra p : palestras){
           System.out.println("##\n");
           System.out.println(p.getTitulo());
           System.out.println("Data "+df.format(p.getDataHora()));
           System.out.println("Palestrantes");
           for(Palestrante pa : p.getPalestrantes()){
               System.out.println(pa.getNome());}
       }
    }

}
