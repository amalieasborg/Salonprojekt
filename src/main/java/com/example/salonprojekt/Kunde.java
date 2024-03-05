package com.example.salonprojekt;

public class Kunde extends Person{
    private int kundeid;

    public Kunde() {
    }

    public Kunde(int kundeid, String brugernavn, String kodeord, String fnavn, String enavn, String mobil, String email) {
        super(brugernavn, kodeord, fnavn, enavn, mobil, email);
        this.kundeid = kundeid;
    }

    public int getKundeid() {
        return kundeid;
    }

    public void setKundeid(int kundeid) {
        this.kundeid = kundeid;
    }

    @Override
    public String toString() {
        return "Kunde{" +
                "kundeid=" + kundeid +
                ", brugernavn='" + brugernavn + '\'' +
                ", kodeord='" + kodeord + '\'' +
                ", fnavn='" + fnavn + '\'' +
                ", enavn='" + enavn + '\'' +
                ", mobil='" + mobil + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
