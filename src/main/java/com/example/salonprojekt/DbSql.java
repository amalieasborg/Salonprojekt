package com.example.salonprojekt;

import java.sql.*;

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
        Medarbejder m=new Medarbejder();
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
            Statement stmt = connection.createStatement();
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
            Statement stmt=connection.createStatement();
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
        Kunde k=new Kunde();
        try {
            String sql = "insert into Kunde (kundeid,brugernavn,kodeord,fnavn,enavn,mobil,email)";
            sql+="values ("+String.valueOf(k.getKundeid())+",'"+k.getBrugernavn()+"','"+k.getKodeord()+"','"+k.getFnavn()+"','"+k.getEnavn()+"','"+k.getMobil()+"','"+k.getEmail()+"')";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void fjernKunde(int kundeid){
        try {
            String sql = "DELETE FROM kunde WHERE kundeid=" + String.valueOf(kundeid);
            Statement stmt = connection.createStatement();
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
            Statement stmt=connection.createStatement();
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


    public void fjernTidsbestilling(int medarbejderid, int kundeid){
        try {
            String sql = "DELETE FROM tidsbestilling WHERE medarbejder="+String.valueOf(medarbejderid);
            sql+= " and kundeid =" + String.valueOf(kundeid);
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
