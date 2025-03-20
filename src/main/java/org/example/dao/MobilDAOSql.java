package org.example.dao;

import org.example.model.Mobiltelefon;

import java.util.List;

public class MobilDAOSql implements MobilDAO{

    @Override
    public List<Mobiltelefon> find() {
        return List.of();
    }

    @Override
    public boolean insert(Mobiltelefon m) {
        return false;
    }
}
