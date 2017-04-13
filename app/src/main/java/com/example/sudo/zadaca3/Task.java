package com.example.sudo.zadaca3;

/**
 * Created by Sudo on 12.4.2017..
 */

public class Task {
    private String Naslov;
    private String Opis;
    private String Prioritet;

    public Task(String naslov, String opis, String prioritet) {
        Naslov = naslov;
        Opis = opis;
        Prioritet = prioritet;
    }

    public String getNaslov() {
        return Naslov;
    }

    public void setNaslov(String naslov) {
        Naslov = naslov;
    }

    public String getOpis() {
        return Opis;
    }

    public void setOpis(String opis) {
        Opis = opis;
    }

    public String getPrioritet() {
        return Prioritet;
    }

    public void setPrioritet(String prioritet) {
        Prioritet = prioritet;
    }
}
