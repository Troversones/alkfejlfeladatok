package org.example.model;

public class Mobiltelefon {
    private String nev;
    private String gyarto;
    private boolean esim;

    public String getGyarto() {
        return gyarto;
    }

    public void setGyarto(String gyarto) {
        this.gyarto = gyarto;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public boolean isEsim() {
        return esim;
    }

    public void setEsim(boolean esim) {
        this.esim = esim;
    }
}
