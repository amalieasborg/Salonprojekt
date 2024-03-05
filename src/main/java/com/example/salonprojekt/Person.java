package com.example.salonprojekt;

abstract class Person {
    protected String brugernavn;
    protected String kodeord;
    protected String fnavn;
    protected String enavn;
    protected String mobil;
    protected String email;

    public Person() {
    }

    public Person(String brugernavn, String kodeord, String fnavn, String enavn, String mobil, String email) {
        this.brugernavn = brugernavn;
        this.kodeord = kodeord;
        this.fnavn = fnavn;
        this.enavn = enavn;
        this.mobil = mobil;
        this.email = email;
    }

    public String getBrugernavn() {
        return brugernavn;
    }

    public void setBrugernavn(String brugernavn) {
        this.brugernavn = brugernavn;
    }

    public String getKodeord() {
        return kodeord;
    }

    public void setKodeord(String kodeord) {
        this.kodeord = kodeord;
    }

    public String getFnavn() {
        return fnavn;
    }

    public void setFnavn(String fnavn) {
        this.fnavn = fnavn;
    }

    public String getEnavn() {
        return enavn;
    }

    public void setEnavn(String enavn) {
        this.enavn = enavn;
    }

    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
