package com.example.diagramcovid.CovidBar;

import com.google.gson.annotations.SerializedName;

public class Covid {
    @SerializedName("FID")
    int FID;

    @SerializedName("Kode_Provi")
    int Kode_Provi;

    @SerializedName("Provinsi")
    String Provinsi;

    @SerializedName("Kasus_Posi")
    int Kasus_Posi;

    @SerializedName("Kasus_Semb")
    int Kasus_Semb;

    @SerializedName("Kasus_Meni")
    int Kasus_Meni;

    public Integer getFID() {
        return FID;
    }

    public void setFID(Integer FID) {
        this.FID = FID;
    }

    public Integer getKode_Provi() {
        return Kode_Provi;
    }

    public void setKode_Provi(Integer kode_Provi) {
        Kode_Provi = kode_Provi;
    }

    public String getProvinsi() {
        return Provinsi;
    }

    public void setProvinsi(String provinsi) {
        Provinsi = provinsi;
    }

    public Integer getKasus_Posi() {
        return Kasus_Posi;
    }

    public void setKasus_Posi(Integer kasus_Posi) {
        Kasus_Posi = kasus_Posi;
    }

    public Integer getKasus_Semb() {
        return Kasus_Semb;
    }

    public void setKasus_Semb(Integer kasus_Semb) {
        Kasus_Semb = kasus_Semb;
    }

    public Integer getKasus_Meni() {
        return Kasus_Meni;
    }

    public void setKasus_Meni(Integer kasus_Meni) {
        Kasus_Meni = kasus_Meni;
    }

}
