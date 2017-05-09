package com.yazlab;

public class Resim{
    private int resimID;
    private String resimYol;
    private int resimEvID;

    public int getResimID() {
        return resimID;
    }

    public void setResimID(int resimID) {
        this.resimID = resimID;
    }

    public String getResimYol() {
        return resimYol;
    }

    public void setResimYol(String resimYol) {
        this.resimYol = resimYol;
    }

    public int getResimEvID() {
        return resimEvID;
    }

    public void setResimEvID(int resimEvID) {
        this.resimEvID = resimEvID;
    }

    @Override
    public String toString() {
        return "Resim{" +
                "resimID=" + resimID +
                ", resimYol='" + resimYol + '\'' +
                ", resimEvID=" + resimEvID +
                '}';
    }
}
