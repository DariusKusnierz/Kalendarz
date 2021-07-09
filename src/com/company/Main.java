package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner skan = new Scanner(System.in);
        Kalendarz kalendarz = new Kalendarz();
        boolean dzialanieProgramu = true;

        przygotowaniePlikow();
        odczytajPlik(kalendarz);
        System.out.println("\nKalendarz tygodniowy ");
        System.out.println("=====================");
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
            System.out.println();

            switch (opcja){
                case 1: noweZadanie(kalendarz); break;
                case 2: noweSpotkanie(kalendarz); break;
                case 3: wyswietlZadanie(kalendarz); break;
                case 4: wyswietlSpotkanie(kalendarz); break;
                case 5: usunZadanie(kalendarz); break;
                case 6: usunSpotkanie(kalendarz); break;
                case 0: dzialanieProgramu = false; break;
                default: break;
            }
        }while(dzialanieProgramu);
    }

    private static void przygotowaniePlikow()  throws IOException {
        File folder = new File("tydzien");
        folder.mkdir();

        for(int i=1; i<=7;i++){
            File plik = new File ("tydzien\\"+i+".txt");
            plik.createNewFile();
        }
    }

    public static void noweZadanie(Kalendarz kalendarz){
        Scanner skan = new Scanner(System.in);
        LocalTime start = LocalTime.of(0,0);
        LocalTime koniec = LocalTime.of(0,0);
        int dzien = 0;
        String opis, priorytet;
        boolean czasPracy = true;

        System.out.println("\nDodawanie nowego zadania");
        do {
            if(!czasPracy) System.out.println("Dzień pracy rozpoczyna się o godzinie "+Zdarzenie.POCZATEK_PRACY);
            try{
                System.out.print("Godzina rozpoczęcia: ");
                start = LocalTime.parse(skan.next());
            }catch (DateTimeParseException e){ System.out.println("Wprowadzono złą godzinę!"); }
            czasPracy = false;
        }while (start.compareTo(Zdarzenie.POCZATEK_PRACY)<0);
        czasPracy = true;
        do {
            if(!czasPracy) System.out.println("Dzień pracy kończy się o godzinie "+Zdarzenie.KONIEC_PRACY);
            try{
                System.out.print("Godzina zakończenia: ");
                koniec = LocalTime.parse(skan.next());
            }catch (DateTimeParseException e){ System.out.println("Wprowadzono złą godzinę!");}
            czasPracy = false;
        }while (koniec.compareTo(Zdarzenie.KONIEC_PRACY)>0);
        do{
            Scanner skanDnia = new Scanner(System.in);
            try{
                System.out.print("Dzień tygodnia: ");
                dzien = skanDnia.nextInt();
            }catch (InputMismatchException e) { System.out.println("Wprowadzono zły dzień!");}
        }while (dzien > 7 || dzien < 1 );

        System.out.print("Opis: ");
        opis = skan.next();
        System.out.print("Priorytet: ");
        priorytet = skan.next();
        kalendarz.dodajZadanie(start,koniec,opis,priorytet,dzien);
        zapiszKalendarz(kalendarz);
    }

    public static void noweSpotkanie(Kalendarz kalendarz){
        Scanner skan = new Scanner(System.in);
        LocalTime start = LocalTime.of(0,0);
        LocalTime koniec = LocalTime.of(0,0);
        int dzien = 0;
        String opis, status;
        boolean czasPracy = true;

        System.out.println("Dodawanie nowego spotkania");
        do {
            if(!czasPracy) System.out.println("Dzień pracy rozpoczyna się o godzinie "+Zdarzenie.POCZATEK_PRACY);
            try{
                System.out.print("Godzina rozpoczęcia: ");
                start = LocalTime.parse(skan.next());
            }catch (DateTimeParseException e){ System.out.println("Wprowadzono złą godzinę!"); }
            czasPracy = false;
        }while (start.compareTo(Zdarzenie.POCZATEK_PRACY)<0);
        czasPracy = true;
        do {
            if(!czasPracy) System.out.println("Dzień pracy kończy się o godzinie "+Zdarzenie.KONIEC_PRACY);
            try{
                System.out.print("Godzina zakończenia: ");
                koniec = LocalTime.parse(skan.next());
            }catch (DateTimeParseException e){ System.out.println("Wprowadzono złą godzinę!");}
            czasPracy = false;
        }while (koniec.compareTo(Zdarzenie.KONIEC_PRACY)>0);
        do{
            Scanner skanDnia = new Scanner(System.in);
            try{
                System.out.print("Dzień tygodnia: ");
                dzien = skanDnia.nextInt();
            }catch (InputMismatchException e) { System.out.println("Wprowadzono zły dzień!");}
        }while (dzien > 7 || dzien < 1 );

        System.out.print("Opis: ");
        opis = skan.next();
        System.out.print("Status: ");
        status = skan.next();
        kalendarz.dodajSpotkanie(start,koniec,opis,status,dzien);
        zapiszKalendarz(kalendarz);
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
                System.out.println("Nr: "+zdarzenia.indexOf(zdarzenie)+" "+zdarzenie);
            }
        }
    }

    private static void zapiszKalendarz(Kalendarz kalendarz){
        for(int i=1; i<=7; i++){
            zapiszPlik(kalendarz.wyswietl(i),i);
        }
    }

    private static void zapiszPlik(ArrayList<Zdarzenie> zdarzenia, int dzien){
        try {
            FileWriter plik = new FileWriter("tydzien\\"+dzien+".txt");
            for (Zdarzenie zdarzenie: zdarzenia){
                plik.write("Nr: "+zdarzenia.indexOf(zdarzenie)+" "+zdarzenie+"\n");
            }
            plik.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void odczytajPlik(Kalendarz kalendarz){
        for(int dzien=1 ; dzien<=7; dzien++){
            try {
                File plik = new File("tydzien\\"+dzien+".txt");
                Scanner czytnik = new Scanner(plik);
                String dane;
                LocalTime start, koniec;
                String opis, dodatkowaInformacja;
                int pozycjaKoncaOpisu;

                while(czytnik.hasNextLine()){
                    dane = czytnik.nextLine();
                    start = LocalTime.parse(dane.substring(20,25));
                    koniec = LocalTime.parse(dane.substring(28,33));
                    dodatkowaInformacja = dane.substring(dane.lastIndexOf(": ")+2);
                    pozycjaKoncaOpisu = dane.lastIndexOf("\"");
                    opis = dane.substring(42,pozycjaKoncaOpisu);

                    if(!dane.contains("Priorytet: ")){
                        kalendarz.dodajSpotkanie(start,koniec,opis,dodatkowaInformacja,dzien);
                    }else{
                        kalendarz.dodajZadanie(start,koniec,opis,dodatkowaInformacja,dzien);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
