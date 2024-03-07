package com.example.salonprojekt;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class DbSql {
    private Connection connection;
    private Statement stmt;
    DbSql() {
        connection = null;
        stmt = null;
        try {
            String url = "jdbc:mysql://localhost:3306/Salonprojekt";
            connection = DriverManager.getConnection(url, "root", "");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void opretMedarbejder(String brugernavn, String kodeord, String fnavn, String enavn, String mobil, String email){
        Medarbejder m=new Medarbejder(brugernavn,kodeord,fnavn,enavn,mobil,email);
        try {
            String sql = "insert into Medarbejder (medarbejderid,brugernavn,kodeord,fnavn,enavn,mobil,email)";
            sql+="values ("+String.valueOf(m.getMedarbejderid())+",'"+m.getBrugernavn()+"','"+m.getKodeord()+"','"+m.getFnavn()+"','"+m.getEnavn()+"','"+m.getMobil()+"','"+m.getEmail()+"')";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void fjernMedarbejder(int medarbejderid){
        try {
            String sql = "DELETE FROM Medarbejder WHERE medarbejderid=" + String.valueOf(medarbejderid);
            stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public Medarbejder soegStamoplysningerMedarbejder(int medarbejderid){
        String sql = "SELECT * from medarbejder where medarbejderid="+String.valueOf(medarbejderid);
        Medarbejder m=new Medarbejder();
        try{
            stmt=connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                m.setMedarbejderid(rs.getInt(1));
                m.setBrugernavn(rs.getString(2));
                m.setKodeord(rs.getString(3));
                m.setFnavn(rs.getString(4));
                m.setEnavn(rs.getString(5));
                m.setMobil(rs.getString(6));
                m.setEmail(rs.getString(7));
            }
            return m;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void opretKunde(String brugernavn, String kodeord, String fnavn, String enavn, String mobil, String email){
        Kunde k=new Kunde(brugernavn,kodeord,fnavn,enavn,mobil,email);
        try {
            String sql = "insert into Kunde (kundeid,brugernavn,kodeord,fnavn,enavn,mobil,email)";
            sql+="values ("+String.valueOf(k.getKundeid())+",'"+k.getBrugernavn()+"','"+k.getKodeord()+"','"+k.getFnavn()+"','"+k.getEnavn()+"','"+k.getMobil()+"','"+k.getEmail()+"')";
            stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void fjernKunde(int kundeid){
        try {
            String sql = "DELETE FROM kunde WHERE kundeid=" + String.valueOf(kundeid);
            stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public Kunde soegStamoplysningerKunde(int kundeid){
        String sql = "SELECT * from kunde where kundeid="+String.valueOf(kundeid);
        Kunde k=new Kunde();
        try{
            stmt=connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                k.setKundeid(rs.getInt(1));
                k.setBrugernavn(rs.getString(2));
                k.setKodeord(rs.getString(3));
                k.setFnavn(rs.getString(4));
                k.setEnavn(rs.getString(5));
                k.setMobil(rs.getString(6));
                k.setEmail(rs.getString(7));
            }
            return k;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void fjernTidsbestilling(int medarbejderid, int kundetidid){
        try {
            String sql = "DELETE FROM tidsbestilling WHERE medarbejderid="+String.valueOf(medarbejderid);
            sql+= " and kundetidid =" + String.valueOf(kundetidid);
            stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void opretTidsbestilling(int medarbejderid,int kundetidid,String tidspunkt,int behandlingid,String kommentarer){
        Tidsbestilling t =new Tidsbestilling(medarbejderid,kundetidid,tidspunkt,behandlingid,kommentarer);
        try{
            String sql="INSERT INTO tidsbestilling(tidsbestillingid,medarbejderid,kundetidid,tidspunkt,behandlingid,kommentarer)";
            sql+=" values ("+String.valueOf(t.getTidsbestillingsid()+","+t.getMedarbejderid()+","+t.getKundeid()+",'"+t.getTidspunkt()+"',"+ t.getBehandlingsid()+",'"+t.getKommentarer()+"')");
            stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }

    public ArrayList soegTidsbestilling(Integer kundetidid) {
        // Initialiser objekter
        ArrayList liste = new ArrayList<>();
        Kunde k = new Kunde();
        Medarbejder m = new Medarbejder();
        Tidsbestilling t = new Tidsbestilling();
        Behandling b = new Behandling();

        // Opdateret SQL-forespørgsel med korrekte JOINs og aliaser
        String sql = "SELECT k.fnavn AS kundeFnavn, k.enavn AS kundeEnavn, m.fnavn AS medarbejderFnavn, " +
                "m.enavn AS medarbejderEnavn, b.type, b.pris, b.varighed, t.tidspunkt, t.kommentarer " +
                "FROM tidsbestilling t " +
                "INNER JOIN kunde k ON t.kundetidid = k.kundeid " +
                "INNER JOIN medarbejder m ON t.medarbejderid = m.medarbejderid " +
                "INNER JOIN behandling b ON t.behandlingid = b.behandlingid " +
                "WHERE t.kundetidid = " + kundetidid;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) { // Antager at der kun findes én tidsbestilling pr. kundetidid
                k.setFnavn(rs.getString("kundeFnavn"));
                k.setEnavn(rs.getString("kundeEnavn"));
                m.setFnavn(rs.getString("medarbejderFnavn"));
                m.setEnavn(rs.getString("medarbejderEnavn"));
                b.setType(rs.getString("type"));
                b.setPris(rs.getInt("pris"));
                b.setVarighed(rs.getInt("varighed"));
                t.setTidspunkt(rs.getString("tidspunkt"));
                t.setKommentarer(rs.getString("kommentarer"));
                liste.add(k);
                liste.add(m);
                liste.add(b);
                liste.add(t);
            }
            return liste;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean login(String brugernavn, String kodeord) {
        String sql = "SELECT kodeord FROM kunde WHERE brugernavn = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, brugernavn);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) { // Kontrollerer, om der er et resultat
                String retrievedPassword = rs.getString("kodeord");
                return kodeord.equals(retrievedPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
