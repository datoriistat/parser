package com.emilburzo.datoriistat.pojo;

public class Datorie {

    public Long cif;
    public String denumire;

    public int op_stat;
    public int oa_stat;
    public int oc_stat;

    public int op_social;
    public int oa_social;
    public int oc_social;

    public int op_somaj;
    public int oa_somaj;
    public int oc_somaj;

    public int op_sanatate;
    public int oa_sanatate;
    public int oc_sanatate;

    public long total;

    public Datorie(String cif, String denumire, String op_stat, String oa_stat, String oc_stat, String op_social, String oa_social, String oc_social, String op_somaj, String oa_somaj, String oc_somaj, String op_sanatate, String oa_sanatate, String oc_sanatate) {
        this.cif = Long.valueOf(cif);
        this.denumire = denumire;
        this.op_stat = Integer.valueOf(op_stat);
        this.oa_stat = Integer.valueOf(oa_stat);
        this.oc_stat = Integer.valueOf(oc_stat);
        this.op_social = Integer.valueOf(op_social);
        this.oa_social = Integer.valueOf(oa_social);
        this.oc_social = Integer.valueOf(oc_social);
        this.op_somaj = Integer.valueOf(op_somaj);
        this.oa_somaj = Integer.valueOf(oa_somaj);
        this.oc_somaj = Integer.valueOf(oc_somaj);
        this.op_sanatate = Integer.valueOf(op_sanatate);
        this.oa_sanatate = Integer.valueOf(oa_sanatate);
        this.oc_sanatate = Integer.valueOf(oc_sanatate);

        // totals
        this.total += this.op_stat;
        this.total += this.oa_stat;

        this.total += this.op_social;
        this.total += this.oa_social;

        this.total += this.op_somaj;
        this.total += this.oa_somaj;

        this.total += this.op_sanatate;
        this.total += this.oa_sanatate;
    }

}
