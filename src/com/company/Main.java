package com.company;

import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner skan = new Scanner(System.in);
        Kalendarz kalendarz = new Kalendarz();
        boolean dzialanieProgramu = true;

        do{
            System.out.println("Wybierz opcję: ");
            System.out.println("1. Nowe zadanie");
            System.out.println("2. Nowe spotkanie");
            System.out.println("3. Wyświetla zadania");
            System.out.println("4. Wyświetla spotkania");
            System.out.println("5. Usuń zadanie");
            System.out.println("6. Usuń spotkanie");
            System.out.println("0. Zakończ");

            int opcja = skan.nextInt();

            switch (opcja){
                case 1: noweZadanie(kalendarz); break;
                case 3: wyswietlZadanie(kalendarz); break;
                case 0: dzialanieProgramu = false; break;
            }

        }while(dzialanieProgramu);
    }

    public static void noweZadanie(Kalendarz kalendarz){
        Scanner skan = new Scanner(System.in);
        LocalTime start, koniec;
        int dzien;
        String opis, priorytet;

        System.out.println("Dodawanie nowego zadania");
        System.out.print("Rozpoczęcie: ");
        start = LocalTime.parse(skan.next());
        System.out.print("Zakończenie: ");
        koniec = LocalTime.parse(skan.next());
        System.out.print("Dzień tygodnia: ");
        dzien = skan.nextInt();
        System.out.print("Opis: ");
        opis = skan.next();
        System.out.print("Priorytet: ");
        priorytet = skan.next();

        kalendarz.dodajZadanie(start,koniec,opis,priorytet,dzien);
    }

    public static  void wyswietlZadanie(Kalendarz kalendarz){
        Scanner skan = new Scanner(System.in);

        System.out.println("Wyświetlanie zadań");
        System.out.print("Dzień tygodnia: ");
        kalendarz.wyswietl(skan.nextInt());
    }
}
