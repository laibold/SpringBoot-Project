package com.laibold.web.controller;

import com.laibold.web.model.benutzer.Benutzer;
import com.laibold.web.persistence.benutzer.BenutzerRepository;
import com.laibold.web.service.BenutzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/benutzer")
public class BenutzerController {

    @Autowired
    BenutzerService benutzerService;

    @GetMapping("/benutzerregistrierung")
    public String benutzerGet(Model m) {
        m.addAttribute("formBenutzer", new Benutzer());
        m.addAttribute("tosError", false);
        return "benutzer/benutzerregistrierung";
    }

    @PostMapping("/benutzerregistrierung")
    public String benutzerPost(Model m, @Valid @ModelAttribute("formBenutzer") Benutzer benutzer, BindingResult result) {
        m.addAttribute("tosError", !benutzer.isAcceptedTOS());

        if (result.hasErrors()) {
            return "benutzer/benutzerregistrierung";
        }
        benutzerService.registerBenutzer(benutzer);
        return "redirect:/login";
    }

}
