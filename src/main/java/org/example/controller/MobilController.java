package org.example.controller;

import org.example.dao.MobilDAO;
import org.example.model.Mobiltelefon;

import java.util.List;

public class MobilController {

    private static MobilDAO dao;
    private static String CONN;
    private static MobilController instance;

    private MobilController(String db){
        CONN = db;
        try{
            Class.forName("jdbc:sqlite:identifier.sqlite");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static MobilController getInstance(String connStr){
        if(instance == null){
            synchronized (MobilController.class){
                if (instance == null){
                    instance = new MobilController(connStr);
                }
            }
        }
        return instance;
    }

    public List<Mobiltelefon> find() {
        return dao.find();
    }

    public boolean insert(Mobiltelefon m) {
        return dao.insert(m);
    }
}
