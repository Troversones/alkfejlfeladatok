package org.example.dao;

import org.example.model.Mobiltelefon;

import java.util.List;

public interface MobilDAO {
    public List<Mobiltelefon> find();
    public boolean insert(Mobiltelefon m);

}
