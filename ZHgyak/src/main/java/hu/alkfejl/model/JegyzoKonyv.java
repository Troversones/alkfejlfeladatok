package hu.alkfejl.model;

public class JegyzoKonyv {

    private String cim, leiras, datum, jegyzo;

    private int id;

    public JegyzoKonyv() {
        cim = leiras = datum = jegyzo = "";
        id = 0;
    }

    public int getId() {
        return id;
    }

    public String getCim() {
        return cim;
    }

    public String getDatum() {
        return datum;
    }

    public String getLeiras() {
        return leiras;
    }

    public String getJegyzo() {
        return jegyzo;
    }

    public void setCim(String ujCim){
        this.cim = ujCim;
    }

    public void setDatum(String ujDatum){
        this.datum = ujDatum;
    }

    public void setLeiras(String ujLeiras){
        this.leiras = ujLeiras;
    }

    public void setJegyzo(String ujJegyzo){
        this.jegyzo = ujJegyzo;
    }

    public void setId(int id) {
        this.id = id;
    }
}
