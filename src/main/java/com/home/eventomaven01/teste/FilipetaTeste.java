package com.home.eventomaven01.teste;

import com.home.eventomaven01.dao.FilipetaDAO;
import com.home.eventomaven01.dao.PalestraDAO;
import com.home.eventomaven01.model.Filipeta;
import com.home.eventomaven01.model.Palestra;
import java.util.Date;

public class FilipetaTeste {
    
    public static void main(String[] args) throws Exception {
        PalestraDAO pDao = new PalestraDAO();
        FilipetaDAO dao = new FilipetaDAO();
        
        Filipeta f = new Filipeta();
        f.setCodigo("1234");
        f.setStatus("Novo");
        f.setValidade(new Date());
        f.setPalestra(pDao.consultaPorId(Palestra.class, 1L));
        
        dao.Salvar(f);
    }
    
}
