package com.company;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args){
        Scanner skan = new Scanner(System.in);
        Kalendarz kalendarz = new Kalendarz();
        boolean dzialanieProgramu = true;
        ArrayList<Zdarzenie> zdarzenia;

        do{
            System.out.println("Wybierz opcję: ");
            System.out.println("1. Nowe zadanie");
            System.out.println("2. Nowe spotkanie");
            System.out.println("3. Wyświetla zadania");
            System.out.println("4. Wyświetla spotkania");
            System.out.println("5. Usuń zadanie");
            System.out.println("6. Usuń spotkanie");
            System.out.println("0. Zakończ");

            System.out.print("Wybieram: ");
            int opcja = skan.nextInt();

            switch (opcja){
                case 1: noweZadanie(kalendarz); break;
                case 2: noweSpotkanie(kalendarz); break;
                case 3: wyswietlZadanie(kalendarz); break;
                case 4: wyswietlSpotkanie(kalendarz); break;
                case 5: usunZadanie(kalendarz); break;
                case 6: usunSpotkanie(kalendarz); break;
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
        do {
            System.out.print("Rozpoczęcie: ");
            start = LocalTime.parse(skan.next());
        }while (start.compareTo(Zdarzenie.POCZATEK_PRACY)<0);

        do {
            System.out.print("Zakończenie: ");
            koniec = LocalTime.parse(skan.next());
        }while (koniec.compareTo(Zdarzenie.KONIEC_PRACY)>0);

        System.out.print("Dzień tygodnia: ");
        dzien = skan.nextInt();
        System.out.print("Opis: ");
        opis = skan.next();
        System.out.print("Priorytet: ");
        priorytet = skan.next();

        kalendarz.dodajZadanie(start,koniec,opis,priorytet,dzien);
    }

    public static void noweSpotkanie(Kalendarz kalendarz){
        Scanner skan = new Scanner(System.in);
        LocalTime start, koniec;
        int dzien;
        String opis, status;

        System.out.println("Dodawanie nowego zadania");
        do {
            System.out.print("Rozpoczęcie: ");
            start = LocalTime.parse(skan.next());
        }while (start.compareTo(Zdarzenie.POCZATEK_PRACY)<0);

        do {
            System.out.print("Zakończenie: ");
            koniec = LocalTime.parse(skan.next());
        }while (koniec.compareTo(Zdarzenie.KONIEC_PRACY)>0);

        System.out.print("Dzień tygodnia: ");
        dzien = skan.nextInt();
        System.out.print("Opis: ");
        opis = skan.next();
        System.out.print("Status: ");
        status = skan.next();

        kalendarz.dodajZadanie(start,koniec,opis,status,dzien);
    }

    public static  void wyswietlZadanie(Kalendarz kalendarz){
        Scanner skan = new Scanner(System.in);

        System.out.println("Wyświetlanie zadań");
        System.out.print("Dzień tygodnia: ");

        wyswietl(kalendarz.wyswietl(skan.nextInt()), e->e instanceof Zadanie);
    }

    public static  void wyswietlSpotkanie(Kalendarz kalendarz){
        Scanner skan = new Scanner(System.in);

        System.out.println("Wyświetlanie spotkań");
        System.out.print("Dzień tygodnia: ");

        wyswietl(kalendarz.wyswietl(skan.nextInt()), e -> e instanceof Spotkanie);
    }

    public static void usunZadanie(Kalendarz kalendarz){
        Scanner skan = new Scanner(System.in);
        int dzien, id;

        System.out.println("Usuwanie zadania");
        System.out.print("Dzień tygodnia: ");
        dzien = skan.nextInt();
        System.out.print("Numer zadania: ");
        id = skan.nextInt();

        kalendarz.usunZadanie(dzien,id);
    }

    public static void usunSpotkanie(Kalendarz kalendarz){
        Scanner skan = new Scanner(System.in);
        int dzien, id;

        System.out.println("Usuwanie spotkania");
        System.out.print("Dzień tygodnia: ");
        dzien = skan.nextInt();
        System.out.print("Numer spotkania: ");
        id = skan.nextInt();

        kalendarz.usunSpotkanie(dzien,id);
    }

    private static void wyswietl(ArrayList<Zdarzenie> zdarzenia, Predicate<Zdarzenie> parametr){
        for(Zdarzenie zdarzenie: zdarzenia){
            if(parametr.test(zdarzenie)){
                System.out.println("Nr: "+zdarzenia.indexOf(zdarzenie)+"\n"+zdarzenie);
            }
        }
    }
}
