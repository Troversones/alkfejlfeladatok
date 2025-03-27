package hu.alkfejl.controller;

import hu.alkfejl.dao.JegyzoKonyvDAO;
import hu.alkfejl.dao.JegyzoKonyvDAOImpl;
import hu.alkfejl.model.JegyzoKonyv;

import java.util.List;

public class JegyzoKonyvController {
    private JegyzoKonyvDAO dao;
    private static JegyzoKonyvController single_instance = null;

    public JegyzoKonyvController(){
        dao = JegyzoKonyvDAOImpl.getInstance();
    }

    public static JegyzoKonyvController getInstance(){
        if(single_instance == null){
            single_instance = new JegyzoKonyvController();
        }
        return single_instance;
    }

    public boolean add(JegyzoKonyv jk){
        dao.add(jk);
        return true;
    }

    public List<JegyzoKonyv> find(JegyzoKonyv jk){
        return dao.find(jk);
    }
}
