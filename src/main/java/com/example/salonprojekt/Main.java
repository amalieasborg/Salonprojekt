package com.example.salonprojekt;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Usecase uc=new Usecase();
        DbSql db=new DbSql();

        Scanner input = new Scanner(System.in);
        System.out.println("1. Opret Medarbejder");
        System.out.println("2. Fjern Medarbejder");
        System.out.println("3. Søg info Medarbejder");
        System.out.println("4. Opret Kunde");
        System.out.println("5. Fjern Kunde");
        System.out.println("6. Søg info Kunde");
        System.out.println("7. Opret tidsbestilling");
        System.out.println("8. Fjern tidsbestilling");
        System.out.println("9. Søg tidsbestilling");
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
                uc.opretKunde("kunde3","Kunde3","Kunde3","Kundesen3","kunde3mobil","kunde3@email.com");
                break;
            case 5:
                uc.fjernKunde(4);
                break;
            case 6:
                Kunde k=uc.soegStamoplysningerKunde(1);
                System.out.println(k);
                break;
            case 7:
                uc.opretTidsbestilling(2,6,"2024-05-07 08:30:00",2,"PLease");
                break;
            case 8:
                uc.fjernTidsbestilling(1,1);
                break;
            case 9:
                System.out.println(uc.soegTidsbestilling(6));
                break;

        }

    }

}


