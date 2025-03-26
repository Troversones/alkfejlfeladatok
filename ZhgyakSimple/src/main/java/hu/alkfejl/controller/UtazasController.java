package hu.alkfejl.controller;

import hu.alkfejl.dao.UtazasDAO;
import hu.alkfejl.dao.UtazasDAOImpl;
import hu.alkfejl.model.Utazas;

import java.util.List;

public class UtazasController {

    private UtazasDAO dao;
    private static UtazasController single_instance = null;

    private UtazasController() {
        dao = UtazasDAOImpl.getInstance();
    }

    public static UtazasController getInstance(){
        if(single_instance == null){ // lazy
            // most nem probléma, de több szálon syncelni kell!
            single_instance = new UtazasController();
        }
        return single_instance;
    }

    public boolean add(Utazas utazas) {
        if ( find(utazas).size() == 0 )
            return dao.add(utazas);
        return false;
    }

    public List<Utazas> find(Utazas filter) {
        return dao.find(filter);
    }
}
