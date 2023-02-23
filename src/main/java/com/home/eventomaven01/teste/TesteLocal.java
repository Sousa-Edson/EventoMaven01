 
package com.home.eventomaven01.teste;

import com.home.eventomaven01.dao.LocalDAO;
import com.home.eventomaven01.model.Local;

 
public class TesteLocal {
    public static void main(String[] args) {
        Local l = new Local();
        l.setPredio("Alphaville");
        l.setSala("J440");
        l.setCapacidade(500);
        l.setId(1L);
        
        LocalDAO dao = new LocalDAO();
        l=dao.Salvar(l);
        
        System.out.println("Local salvo "+l.getId()+" "+l.getPredio()+" "+l.getSala()+" "+l.getCapacidade());
    }
}
