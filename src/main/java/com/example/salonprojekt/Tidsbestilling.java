package com.example.salonprojekt;

public class Tidsbestilling {
    private int tidsbestillingsid;
    private int medarbejderid;
    private int kundeid;
    private String tidspunkt;
    private int behandlingsid;
    private String kommentarer;

    public Tidsbestilling() {
    }

    public Tidsbestilling(int medarbejderid, int kundeid, String tidspunkt, int behandlingsid, String kommentarer) {
        this.medarbejderid = medarbejderid;
        this.kundeid = kundeid;
        this.tidspunkt = tidspunkt;
        this.behandlingsid = behandlingsid;
        this.kommentarer = kommentarer;
    }

    public Tidsbestilling(int tidsbestillingsid, int medarbejderid, int kundeid, String tidspunkt, int behandlingsid, String kommentarer) {
        this.tidsbestillingsid = tidsbestillingsid;
        this.medarbejderid = medarbejderid;
        this.kundeid = kundeid;
        this.tidspunkt = tidspunkt;
        this.behandlingsid = behandlingsid;
        this.kommentarer = kommentarer;
    }

    public int getTidsbestillingsid() {
        return tidsbestillingsid;
    }

    public void setTidsbestillingsid(int tidsbestillingsid) {
        this.tidsbestillingsid = tidsbestillingsid;
    }

    public int getMedarbejderid() {
        return medarbejderid;
    }

    public void setMedarbejderid(int medarbejderid) {
        this.medarbejderid = medarbejderid;
    }

    public int getKundeid() {
        return kundeid;
    }

    public void setKundeid(int kundeid) {
        this.kundeid = kundeid;
    }

    public String getTidspunkt() {
        return tidspunkt;
    }

    public void setTidspunkt(String tidspunkt) {
        this.tidspunkt = tidspunkt;
    }

    public int getBehandlingsid() {
        return behandlingsid;
    }

    public void setBehandlingsid(int behandlingsid) {
        this.behandlingsid = behandlingsid;
    }

    public String getKommentarer() {
        return kommentarer;
    }

    public void setKommentarer(String kommentarer) {
        this.kommentarer = kommentarer;
    }



    @Override
    public String toString() {
        return "Tidsbestilling{" +
                "tidsbestillinsid=" + tidsbestillingsid +
                ", medarbejderid=" + medarbejderid +
                ", kundeid=" + kundeid +
                ", tidspunkt='" + tidspunkt + '\'' +
                ", behandlingsid=" + behandlingsid +
                ", kommentarer='" + kommentarer + '\'' +
                '}';
    }
}
