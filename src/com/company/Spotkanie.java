package com.company;

import java.time.LocalTime;

public class Spotkanie extends Zdarzenie {
    private String status;

    public Spotkanie(LocalTime start, LocalTime koniec, String opis, String status){
        super(start,koniec,opis);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return super.toString() + "\t Status: " + status;
    }
}
