package com.example.salonprojekt;

public class Medarbejder extends Person{
    private int medarbejderid;

    public Medarbejder() {
    }

    public Medarbejder(int medarbejderid, String brugernavn, String kodeord, String fnavn, String enavn, String mobil, String email) {
        super(brugernavn, kodeord, fnavn, enavn, mobil, email);
        this.medarbejderid = medarbejderid;
    }

    public int getMedarbejderid() {
        return medarbejderid;
    }

    public void setMedarbejderid(int medarbejderid) {
        this.medarbejderid = medarbejderid;
    }

    @Override
    public String toString() {
        return "Medarbejder{" +
                "medarbejderid=" + medarbejderid +
                ", brugernavn='" + brugernavn + '\'' +
                ", kodeord='" + kodeord + '\'' +
                ", fnavn='" + fnavn + '\'' +
                ", enavn='" + enavn + '\'' +
                ", mobil='" + mobil + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
