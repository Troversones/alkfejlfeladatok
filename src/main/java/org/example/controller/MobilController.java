package org.example.controller;

import org.example.dao.MobilDAO;
import org.example.model.Mobiltelefon;

import java.util.List;

public class MobilController {

    private static MobilDAO dao;
    private static MobilController instance;

    private MobilController(String db){

    }

    public static MobilController getInstance(){

    }

    public List<Mobiltelefon> find() {
        return dao.find();
    }

    public boolean insert(Mobiltelefon m) {
        return dao.insert(m);
    }
}
