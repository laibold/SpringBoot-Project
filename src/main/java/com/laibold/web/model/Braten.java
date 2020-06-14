package com.laibold.web.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.laibold.web.model.benutzer.Benutzer;
import com.laibold.web.service.tools.validation.Address;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
@Entity
public class Braten {

    @Id
    @GeneratedValue
    private int id;

    @Version
    private long version;

    @ManyToOne
    @JsonIdentityReference(alwaysAsId = true)
    private Benutzer anbieter;

    @Address(message = "{address.invalid}")
    private String abholort;

    @Size(max = 80, message = "{description.length}")
    @NotBlank(message = "{description.blank}")
    private String beschreibung;

    @NotNull(message = "{bbe.invalid}")
    @FutureOrPresent(message = "{bbe.past}")
    private LocalDate haltbarBis;

    @Transient
    @JsonIgnore
    private int[] veggieWerte;

    private int veggieAuswahl; // SelectBox Einfachauswahl

    public Braten() {
        initFormValues();
    }

    public Braten(Benutzer anbieter, String abholort, LocalDate haltbarBis, String beschreibung) {
        this.anbieter = anbieter;
        this.abholort = abholort;
        this.haltbarBis = haltbarBis;
        this.beschreibung = beschreibung;
        initFormValues();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public Benutzer getAnbieter() {
        return anbieter;
    }

    public void setAnbieter(Benutzer anbieter) {
        this.anbieter = anbieter;
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
        String anbieterName = anbieter.getFullName() != "" ? anbieter.getFullName() : anbieter.getUsername();
        s += "Anbieter: " + anbieterName + "\n";
        s += "Abholort: " + abholort + "\n";
        s += "Haltbar bis: " + haltbarBis + "\n";
        s += "Beschreibung: " + beschreibung + "\n";
        return s;
    }

    public void initFormValues() {
        this.veggieWerte = new int[]{0, 25, 50, 100};
    }
}