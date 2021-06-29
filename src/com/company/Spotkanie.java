package com.company;

import java.time.LocalDate;

public class Spotkanie extends Zdarzenie {
    private String status;

    public Spotkanie(LocalDate start, LocalDate koniec, String opis, String status){
        super(start,koniec,opis);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
