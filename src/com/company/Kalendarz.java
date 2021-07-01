package com.company;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Kalendarz {

    private ArrayList<Zdarzenie>[] kalendarz = new ArrayList[7];

    public Kalendarz(){
        for(int i = 0; i<7; i++){
            kalendarz[i] = new ArrayList<Zdarzenie>();
        }
    }

    public void dodajZadanie(LocalTime start, LocalTime koniec, String opis, String priorytet, int dzien){
        Zadanie noweZadanie = new Zadanie(start, koniec, opis, priorytet);
        kalendarz[dzien-1].add(noweZadanie);
    }

    public void usunZadanie(int dzien, int id){
        kalendarz[dzien-1].remove(id);
    }

    public void dodajSpotkanie(LocalTime start, LocalTime koniec, String opis, String status, int dzien){
        Spotkanie noweSpotkanie = new Spotkanie(start, koniec, opis, status);
        kalendarz[dzien-1].add(noweSpotkanie);
    }

    public void usunSpotkanie(int dzien, int id){
        kalendarz[dzien-1].remove(id);
    }

    public ArrayList wyswietl(int dzien){
         return kalendarz[dzien-1];
    }
}
