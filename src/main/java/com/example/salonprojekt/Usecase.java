package com.example.salonprojekt;
public class Usecase {
    private DbSql db=new DbSql();
    private Medarbejder m;
    private Kunde k;
    public void opretMedarbejder(String brugernavn, String kodeord, String fnavn, String enavn, String mobil, String email){
        db.opretMedarbejder(brugernavn,kodeord,fnavn,enavn,mobil,email);
    }
    public void fjernMedarbejder(int medarbejderid){
        db.fjernMedarbejder(medarbejderid);
    }
    public Medarbejder soegStamoplysningerMedarbejder(int medarbejderid){
        m=db.soegStamoplysningerMedarbejder(medarbejderid);
        return m;
    }
    public void opretKunde(String brugernavn, String kodeord, String fnavn, String enavn, String mobil, String email){
        db.opretKunde(brugernavn,kodeord,fnavn,enavn,mobil,email);
    }
    public void fjernKunde(int kundeid){
        db.fjernKunde(kundeid);
    }
    public Kunde soegStamoplysningerKunde(int kundeid){
        k=db.soegStamoplysningerKunde(kundeid);
        return k;
    }

}
