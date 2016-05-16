package com.emilburzo.datoriistat.pojo;

public class Stare {

    public Integer cod;
    public String denumire;

    public Stare(String cod, String denumire) {
        this.cod = Integer.valueOf(cod.trim());
        this.denumire = denumire;
    }

    @Override
    public String toString() {
        return "Stare{" +
                "cod=" + cod +
                ", denumire='" + denumire + '\'' +
                '}';
    }
}
