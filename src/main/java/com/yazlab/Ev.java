package com.yazlab;

public class Ev {

    private int evID;
    private String evIL;
    private String evEmlakTipi;
    private int evAlan;
    private int evOdaSayisi;
    private int evBinaYasi;
    private int evBulKat;
    private double evFiyat;
    private String evAciklama;

    public int getEvID() {
        return evID;
    }

    public void setEvID(int evID) {
        this.evID = evID;
    }

    public String getEvIL() {
        return evIL;
    }

    public void setEvIL(String evIL) {
        this.evIL = evIL;
    }

    public String getEvEmlakTipi() {
        return evEmlakTipi;
    }

    public void setEvEmlakTipi(String evEmlakTipi) {
        this.evEmlakTipi = evEmlakTipi;
    }

    public int getEvAlan() {
        return evAlan;
    }

    public void setEvAlan(int evAlan) {
        this.evAlan = evAlan;
    }

    public int getEvOdaSayisi() {
        return evOdaSayisi;
    }

    public void setEvOdaSayisi(int evOdaSayisi) {
        this.evOdaSayisi = evOdaSayisi;
    }

    public int getEvBinaYasi() {
        return evBinaYasi;
    }

    public void setEvBinaYasi(int evBinaYasi) {
        this.evBinaYasi = evBinaYasi;
    }

    public int getEvBulKat() {
        return evBulKat;
    }

    public void setEvBulKat(int evBulKat) {
        this.evBulKat = evBulKat;
    }

    public double getEvFiyat() {
        return evFiyat;
    }

    public void setEvFiyat(double evFiyat) {
        this.evFiyat = evFiyat;
    }

    public String getEvAciklama() {
        return evAciklama;
    }

    public void setEvAciklama(String evAciklama) {
        this.evAciklama = evAciklama;
    }

    @Override
    public String toString() {
        return "Ev{" +
                "evID=" + evID +
                ", evIL='" + evIL + '\'' +
                ", evEmlakTipi='" + evEmlakTipi + '\'' +
                ", evAlan=" + evAlan +
                ", evOdaSayisi=" + evOdaSayisi +
                ", evBinaYasi=" + evBinaYasi +
                ", evBulKat=" + evBulKat +
                ", evFiyat=" + evFiyat +
                ", evAciklama='" + evAciklama + '\'' +
                '}';
    }
}
