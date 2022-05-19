package com.example.carapp;
public class Arabalar {
    int id;
    String aracModel;
    int aracYIL;
    int aracKM;
    int aracFiyat;

    public Arabalar(String aracModel, int aracYIL, int aracKM, int aracFiyat) {
        this.aracModel = aracModel;
        this.aracYIL = aracYIL;
        this.aracKM = aracKM;
        this.aracFiyat = aracFiyat;
    }

    public Arabalar() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAracModel() {
        return aracModel;
    }

    public void setAracModel(String aracModel) {
        this.aracModel = aracModel;
    }

    public int getAracYIL() {
        return aracYIL;
    }

    public void setAracYIL(int aracYIL) {
        this.aracYIL = aracYIL;
    }

    public int getAracKM() {
        return aracKM;
    }

    public void setAracKM(int aracKM) {
        this.aracKM = aracKM;
    }

    public int getAracFiyat() {
        return aracFiyat;
    }

    public void setAracFiyat(int aracFiyat) {
        this.aracFiyat = aracFiyat;
    }


}
