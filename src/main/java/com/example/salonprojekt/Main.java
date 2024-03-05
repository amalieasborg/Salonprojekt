package com.example.salonprojekt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Usecase uc=new Usecase();

        Scanner input = new Scanner(System.in);
        System.out.println("1. Opret Medarbejder");
        System.out.println("2. Fjern Medarbejder");
        System.out.println("3. Søg info Medarbejder");
        System.out.println("4. Søg info Kunde");
        System.out.println("5. Opret Kunde");
        System.out.println("6. Fjern Kunde");
        int valg = input.nextInt();
        switch (valg) {
            case 1:
                uc.opretMedarbejder("Amalieasborg","2345","Amalie","Hansen","22712447","amalie@gmail.com");
                break;
            case 2:
                uc.fjernMedarbejder(5);
                break;
            case 3:
                Medarbejder m=uc.soegStamoplysningerMedarbejder(1);
                System.out.println(m);
                break;
            case 4:
                Kunde k=uc.soegStamoplysningerKunde(1);
                System.out.println(k);
                break;
            case 5:
                uc.opretKunde("kunde2","Kunde2","Kunde2","Kundesen2","kunde2mobil","kunde2@email.com");
                break;
            case 6:
                uc.fjernKunde(4);
                break;
        }

    }

}


