package com.emilburzo.datoriistat.pojo;

public class Firma {

    public String denumire;
    public Long cif;
    public String cod;
    public String stari;
    public String judet;
    public String localitate;

    public Firma(String denumire, String cif, String cod, String stari, String judet, String localitate) {
        this.denumire = denumire;
        this.cif = Long.valueOf(cif);
        this.cod = cod;
        this.stari = stari;
        this.judet = judet;
        this.localitate = localitate;
    }
}
