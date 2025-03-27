package hu.alkfejl.dao;

import hu.alkfejl.model.JegyzoKonyv;

import java.util.List;

public interface JegyzoKonyvDAO {
    List<JegyzoKonyv> find(JegyzoKonyv jk);
    Boolean add(JegyzoKonyv jk);
}
