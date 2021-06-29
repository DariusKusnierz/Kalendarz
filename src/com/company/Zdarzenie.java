package com.company;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Zdarzenie {
    protected LocalDate czas_poczatku;
    protected LocalDate czas_zakonczenia;
    protected String opis;

    protected Zdarzenie(LocalDate start, LocalDate koniec, String opis){
        this.czas_poczatku = start;
        this.czas_zakonczenia = koniec;
        this.opis = opis;
    }

    public static final LocalTime KONIEC_PRACY = LocalTime.of(22,0);
    public static final LocalTime POCZATEK_PRACY = LocalTime.of(8,0);

    public LocalDate getCzas_poczatku() {
        return czas_poczatku;
    }

    public void setCzas_poczatku(LocalDate czas_poczatku) {
        this.czas_poczatku = czas_poczatku;
    }

    public LocalDate getCzas_zakonczenia() {
        return czas_zakonczenia;
    }

    public void setCzas_zakonczenia(LocalDate czas_zakonczenia) {
        this.czas_zakonczenia = czas_zakonczenia;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
