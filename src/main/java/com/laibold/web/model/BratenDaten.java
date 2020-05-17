package com.laibold.web.model;


import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class BratenDaten {
    @Size(min=3, message="Name muss mindestens {min} Zeichen lang sein")
    private String name;

    @NotBlank(message="Darf nicht leer sein")
    private String abholort;

    @Size(max=80, message="Beschreibung darf maximal {max} Zeichen lang sein")
    @NotBlank(message="Darf nicht leer sein")
    private String beschreibung;

    @NotNull(message="Darf nicht null sein") // TODO fehler wenn nichts eingegeben
    @FutureOrPresent
    @Valid
    private LocalDate haltbarBis;

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