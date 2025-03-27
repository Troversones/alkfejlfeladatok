package hu.alkfejl.dao;

import hu.alkfejl.model.JegyzoKonyv;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JegyzoKonyvDAOImpl implements JegyzoKonyvDAO{
    private static JegyzoKonyvDAOImpl object = new JegyzoKonyvDAOImpl();
    public static JegyzoKonyvDAOImpl getInstance() {return object;}

    private List<JegyzoKonyv> inMemoryDB;
    public JegyzoKonyvDAOImpl() {
        inMemoryDB = new ArrayList<>();
    }

    @Override
    public List<JegyzoKonyv> find(JegyzoKonyv jk) {
        return inMemoryDB.stream()
                .filter(jegyzokonyv -> jk.getDatum() == null || jegyzokonyv.getDatum().equals(jk.getDatum()))
                .filter(jegyzokonyv -> jk.getCim() == null || jegyzokonyv.getCim().equals(jk.getCim()))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean add(JegyzoKonyv jk) {
        inMemoryDB.add(jk);
        return true;
    }
}
