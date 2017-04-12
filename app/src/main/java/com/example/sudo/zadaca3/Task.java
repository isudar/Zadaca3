package com.example.sudo.zadaca3;

/**
 * Created by Sudo on 12.4.2017..
 */

public class Task {
    private String Naslov;
    private String Sadrzaj;
    private String Prioritet;

    public Task(String naslov, String sadrzaj, String prioritet) {
        Naslov = naslov;
        Sadrzaj = sadrzaj;
        Prioritet = prioritet;
    }

    public String getNaslov() {
        return Naslov;
    }

    public void setNaslov(String naslov) {
        Naslov = naslov;
    }

    public String getSadrzaj() {
        return Sadrzaj;
    }

    public void setSadrzaj(String sadrzaj) {
        Sadrzaj = sadrzaj;
    }

    public String getPrioritet() {
        return Prioritet;
    }

    public void setPrioritet(String prioritet) {
        Prioritet = prioritet;
    }
}
