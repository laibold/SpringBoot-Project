package com.laibold.web.controller;

import com.laibold.web.model.Braten;

import com.laibold.web.model.benutzer.Benutzer;
import com.laibold.web.service.BenutzerService;
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
import java.util.Optional;

@Controller
@RequestMapping("/braten")
@SessionAttributes(names = {"loggedInUser"})
public class BratenWebController {

    @Autowired
    BratenService bratenService;

    /**
     * Liste anzeigen
     */
    @GetMapping("/angebot")
    public String angebotGet(Model m) {
        m.addAttribute("angebotListe", bratenService.getAllBraten());
        return "braten/liste";
    }

    /**
     * Neues Element in Liste POSTen
     */
    @PostMapping("/angebot/neu")
    public String listePost(@Valid @ModelAttribute("formBraten") Braten formBraten, BindingResult result,
                            @ModelAttribute("loggedInUser") Benutzer loggedInUser) {
        if (result.hasErrors()) {
            return "braten/bearbeiten";
        }
        bratenService.addBraten(loggedInUser.getUsername(), formBraten);
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
    @GetMapping("/angebot/{i}/del")
    public String deleteAngebot(@PathVariable int i, @ModelAttribute("angebotListe") ArrayList<Braten> angebotListe) {
        Optional<Braten> braten = bratenService.getBratenById(i);
        if (braten.isPresent()) {
            // Wenn Element noch vorhanden
            bratenService.removeBraten(i);
        }
        return "braten/liste";
    }

    /**
     * i-tes Element aus der Liste entfernen und Inhalte auf der bearbeiten-Seite anzeigen
     */
    @GetMapping("/angebot/{i}")
    public String editAngebot(Model m, @PathVariable int i, @ModelAttribute("angebotListe") ArrayList<Braten> angebotListe) {
        Optional<Braten> braten = bratenService.getBratenById(i);
        if (braten.isPresent()) {
            m.addAttribute("formBraten", braten);
            bratenService.removeBraten(i);
            return "braten/bearbeiten";
        }
        // Fehlerfall Element nicht mehr vorhanden
        return "braten/liste";
    }

}
