package com.home.eventomaven01.teste;

import com.home.eventomaven01.dao.LocalDAO;
import com.home.eventomaven01.model.Local;

public class LocalTeste {

    public static void main(String[] args) throws Exception {
        Local l = new Local();
        l.setPredio("São Paulo");
        l.setSala("SP001");
        l.setCapacidade(30);
        
        LocalDAO dao = new LocalDAO();
        l = dao.Salvar(l); // executa o insert
        
        System.out.println("Local salvo " + l.getId() + " " + l.getPredio() + " " + l.getSala() + " " + l.getCapacidade());
        
        Local l2 = dao.consultaPorId(l.getId()); // executa o update
        System.out.println("Consultado o local " + l.getId() + " " + l.getCapacidade());
        l2.setCapacidade(120);
        l2 = dao.Salvar(l2);
        
        System.out.println("Local salvo " + l2.getId() + " " + l2.getPredio() + " " + l2.getSala() + " " + l2.getCapacidade());
        
        dao.remover(l2.getId()); // executa delete
        System.out.println("O local foi deletado");
    }
    
}
