package com.example.salonprojekt;

public class Behandling {
    private int behandlingID;
    private String type;
    private int varighed;
    private int pris;

    public Behandling() {
    }

    public Behandling(int behandlingID, String type, int varighed, int pris) {
        this.behandlingID = behandlingID;
        this.type = type;
        this.varighed = varighed;
        this.pris = pris;
    }

    public int getBehandlingID() {
        return behandlingID;
    }

    public void setBehandlingID(int behandlingID) {
        this.behandlingID = behandlingID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getVarighed() {
        return varighed;
    }

    public void setVarighed(int varighed) {
        this.varighed = varighed;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

}
