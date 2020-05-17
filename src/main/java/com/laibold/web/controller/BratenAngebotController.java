package com.laibold.web.controller;

import com.laibold.web.model.BratenDaten;
import com.laibold.web.model.formular.BratenDatenFormular;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;


@Controller
@RequestMapping("/angebot")
@SessionAttributes(names = {"angebotListe"})
public class BratenAngebotController {

    /**
     * Session-Attribut initialisieren
     */
    @ModelAttribute("angebotListe")
    public void initAngebotListe(Model m) {
        m.addAttribute("angebotListe", new ArrayList<BratenDaten>());
    }

    /**
     * Liste anzeigen
     */
    @GetMapping("/liste")
    public String listeGet(@ModelAttribute("angebotListe") ArrayList<BratenDaten> angebotListe) {
        return "angebot/liste";
    }

    /**
     * Neues Element in Liste POSTen
     */
    @PostMapping("/liste")
    public String listePost(@ModelAttribute("bratenFormular") BratenDaten bratenFormular,
                            @ModelAttribute("angebotListe") ArrayList<BratenDaten> angebotListe) {
        angebotListe.add(bratenFormular);
        return "angebot/liste";
    }

    /**
     * Neues Element im bearbeiten-Formular anlegen
     */
    @GetMapping("/neu")
    public String neuGet(Model m) {
        m.addAttribute("formBraten", new BratenDaten());
        return "angebot/bearbeiten";
    }

    /**
     * i-tes Element aus der Liste entfernen und Inhalte im bearbeiten-Formular anzeigen
     */
    @GetMapping("/del/{i}")
    public String deleteAngebot(@PathVariable int i, @ModelAttribute("angebotListe") ArrayList<BratenDaten> angebotListe) {
        if (!angebotListe.isEmpty() && angebotListe.size() >= i) {
            // Wenn Element noch vorhanden
            angebotListe.remove(i);
        }
        return "angebot/liste";
    }

    /**
     * i-tes Element aus der Liste entfernen und Inhalte auf der bearbeiten-Seite anzeigen
     */
    @GetMapping("/bearbeiten/{i}")
    public String editAngebot(Model m, @PathVariable int i, @ModelAttribute("angebotListe") ArrayList<BratenDaten> angebotListe) {
        if (!angebotListe.isEmpty() && angebotListe.size() >= i) {
            m.addAttribute("formBraten", angebotListe.get(i));
            angebotListe.remove(i);
            return "angebot/bearbeiten";
        }
        // Fehlerfall Element nicht mehr vorhanden
        return "angebot/liste";
    }

}
