package com.example.salonprojekt;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TooManyListenersException;

public class Usecase {
    private DbSql db=new DbSql();
    private Medarbejder m;
    private Kunde k;
    private Tidsbestilling t;
    private ArrayList <Tidsbestilling> tidliste;
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

    public void opretTidsbestilling(int medarbejderid, int kundetidid,String tidspunkt,int behandlingid,String kommentarer){
        db.opretTidsbestilling(medarbejderid,kundetidid,tidspunkt,behandlingid,kommentarer);
    }
    public void fjernTidsbestilling(int medarbejderid, int kundetidid){
        db.fjernTidsbestilling(medarbejderid,kundetidid);
    }
    public ArrayList soegTidsbestilling(int kundetidid) {
        tidliste=db.soegTidsbestilling(kundetidid);
        return tidliste;
    }

    public boolean login(String brugernavn, String kodeord) throws SQLException {
        boolean login =  db.login(brugernavn, kodeord);
        return login;
    }

}
