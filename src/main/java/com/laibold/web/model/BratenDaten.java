package com.laibold.web.model;

import com.laibold.web.tools.validation.Address;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class BratenDaten {
    @Size(min = 3, message="{name.length}")
    private String name;

    @Address(message = "{address.invalid}")
    private String abholort;

    @Size(max = 80, message="{description.length}")
    @NotBlank(message="{description.blank}")
    private String beschreibung;

    @NotNull(message="{bbe.invalid}")
    @FutureOrPresent(message="{bbe.past}")
    private LocalDate haltbarBis;

    private int[] veggieWerte = {0, 25, 50, 100};

    private int veggieAuswahl; // SelectBox Einfachauswahl

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

    public int[] getVeggieWerte() {
        return veggieWerte;
    }

    public int getVeggieAuswahl() {
        return veggieAuswahl;
    }

    public void setVeggieAuswahl(int veggieAuswahl) {
        this.veggieAuswahl = veggieAuswahl;
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