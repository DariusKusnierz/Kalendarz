package com.company;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Zdarzenie {
    protected LocalTime czas_poczatku;
    protected LocalTime czas_zakonczenia;
    protected String opis;

    protected Zdarzenie(LocalTime start, LocalTime koniec, String opis){
        this.czas_poczatku = start;
        this.czas_zakonczenia = koniec;
        this.opis = opis;
    }

    public static final LocalTime KONIEC_PRACY = LocalTime.of(22,0);
    public static final LocalTime POCZATEK_PRACY = LocalTime.of(8,0);

    public LocalTime getCzas_poczatku() {
        return czas_poczatku;
    }

    public void setCzas_poczatku(LocalTime czas_poczatku) {
        this.czas_poczatku = czas_poczatku;
    }

    public LocalTime getCzas_zakonczenia() {
        return czas_zakonczenia;
    }

    public void setCzas_zakonczenia(LocalTime czas_zakonczenia) {
        this.czas_zakonczenia = czas_zakonczenia;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String toString() {
        return "Czas trwania: " + czas_poczatku + " - " + czas_zakonczenia + "\t Opis: \"" + opis + "\"";
    }
}
