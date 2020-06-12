package com.laibold.web.controller;

import com.laibold.web.model.Braten;

import com.laibold.web.service.BratenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("/braten")
@SessionAttributes(names = {"angebotListe"})
public class BratenWebController {

    @Autowired
    BratenService bratenService;

    /**
     * Session-Attribut initialisieren
     */
    @ModelAttribute("angebotListe")
    public void initAngebotListe(Model m) {
        m.addAttribute("angebotListe", new ArrayList<Braten>());
    }

    /**
     * Liste anzeigen
     */
    @GetMapping("/liste")
    public String listeGet(@ModelAttribute("angebotListe") ArrayList<Braten> angebotListe) {
        return "braten/liste";
    }

    /**
     * Neues Element in Liste POSTen
     */
    @PostMapping("/neu")
    public String listePost(@Valid @ModelAttribute("formBraten") Braten formBraten, BindingResult result,
                            @ModelAttribute("angebotListe") ArrayList<Braten> angebotListe) {
        if (result.hasErrors()) {
            return "braten/bearbeiten";
        }
        angebotListe.add(formBraten);
        return "redirect:/braten/liste";
    }

    /**
     * Neues Element im bearbeiten-Formular anlegen
     */
    @GetMapping("/neu")
    public String neuGet(Model m) {
        m.addAttribute("formBraten", new Braten());
        return "braten/bearbeiten";
    }

    /**
     * i-tes Element aus der Liste entfernen und Inhalte im bearbeiten-Formular anzeigen
     */
    @GetMapping("/del/{i}")
    public String deleteAngebot(@PathVariable int i, @ModelAttribute("angebotListe") ArrayList<Braten> angebotListe) {
        if (!angebotListe.isEmpty() && angebotListe.size() >= i) {
            // Wenn Element noch vorhanden
            angebotListe.remove(i);
        }
        return "braten/liste";
    }

    /**
     * i-tes Element aus der Liste entfernen und Inhalte auf der bearbeiten-Seite anzeigen
     */
    @GetMapping("/bearbeiten/{i}")
    public String editAngebot(Model m, @PathVariable int i, @ModelAttribute("angebotListe") ArrayList<Braten> angebotListe) {
        if (!angebotListe.isEmpty() && angebotListe.size() > i) {
            m.addAttribute("formBraten", angebotListe.get(i));
            angebotListe.remove(i);
            return "braten/bearbeiten";
        }
        // Fehlerfall Element nicht mehr vorhanden
        return "braten/liste";
    }

}
