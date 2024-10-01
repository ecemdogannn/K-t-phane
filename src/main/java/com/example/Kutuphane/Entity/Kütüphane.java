package com.example.Kutuphane.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "kitaplar")
public class Kütüphane {

    @Id
    private String id;
    private String kitapAd;
    private String yazarAd;
    private int sayfaSayısı;

    public Kütüphane (){

    }

    public Kütüphane(String id, String kitapAd, String yazarAd, int sayfaSayısı) {
        this.id = id;
        this.kitapAd = kitapAd;
        this.yazarAd = yazarAd;
        this.sayfaSayısı = sayfaSayısı;
    }

    public String getKitapAd() {
        return kitapAd;
    }

    public void setKitapAd(String kitapAd) {
        this.kitapAd = kitapAd;
    }

    public String getYazarAd() {
        return yazarAd;
    }

    public void setYazarAd(String yazarAd) {
        this.yazarAd = yazarAd;
    }

    public int getSayfaSayısı() {
        return sayfaSayısı;
    }

    public void setSayfaSayısı(int sayfaSayısı) {
        this.sayfaSayısı = sayfaSayısı;
    }



    @Override
    public String toString() {
        return "Kütüphane{" +
                "id='" + id + '\'' +
                ", kitapAd='" + kitapAd + '\'' +
                ", yazarAd='" + yazarAd + '\'' +
                ", sayfaSayısı='" + sayfaSayısı + '\'' +
                '}';
    }
}
