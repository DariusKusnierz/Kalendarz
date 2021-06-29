package com.company;

import java.time.LocalDate;

public class Zadanie extends Zdarzenie{
    private String priorytet;

    public Zadanie(LocalDate start, LocalDate koniec, String opis, String priorytet){
        super(start, koniec, opis);
        this.priorytet = priorytet;
    }

    public String getPriorytet() {
        return priorytet;
    }

    public void setPriorytet(String priorytet) {
        this.priorytet = priorytet;
    }
}
