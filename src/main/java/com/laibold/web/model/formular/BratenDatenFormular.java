package com.laibold.web.model.formular;

import java.time.LocalDate;

import com.laibold.web.model.BratenDaten;

public class BratenDatenFormular {
    String name;
    String abholort;
    LocalDate haltbarBis;
    String beschreibung;

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

	public BratenDaten getBratenDaten() {
		return new BratenDaten(name, abholort, haltbarBis, beschreibung);
	}
}