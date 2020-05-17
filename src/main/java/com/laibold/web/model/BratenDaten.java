package com.laibold.web.model;

import java.time.LocalDate;

public class BratenDaten {
    String name;
    String abholort;
    LocalDate haltbarBis;
    String beschreibung;

    public BratenDaten() {

    }

    public BratenDaten(String name, String abholort, LocalDate haltbarBis, String beschreibung) {
        this.name = name;
        this.abholort = abholort;
        this.haltbarBis = haltbarBis;
        this.beschreibung = beschreibung;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbholort() {
        return abholort;
    }

    public void setAbholort(String abholort) {
        this.abholort = abholort;
    }

    public LocalDate getHaltbarBis() {
        return haltbarBis;
    }

    public void setHaltbarBis(LocalDate haltbarBis) {
        this.haltbarBis = haltbarBis;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String toString() {
        String s = "BratenDaten";
        s += "Name: " + name + "\n";
        s += "Abholort: " + abholort + "\n";
        s += "Haltbar bis: " + haltbarBis + "\n";
        s += "Beschreibung: " + beschreibung + "\n";
        return s;
    }
}