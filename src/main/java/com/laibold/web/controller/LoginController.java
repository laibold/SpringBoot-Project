package com.laibold.web.controller;

import com.laibold.web.model.benutzer.Benutzer;
import com.laibold.web.service.BenutzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
@SessionAttributes(names = {"loggedInUser"})
public class LoginController {

    @Autowired
    BenutzerService benutzerService;

    /**
     * Session-Attribut initialisieren
     */
    @ModelAttribute("loggedInUser")
    public void initLoggedInUser(Model m) {
        m.addAttribute("loggedInUser", new Benutzer());
    }

    @GetMapping("")
    public String loginGet(Model m) {
        return "login";
    }

    @PostMapping("")
    public String loginPost(Model m, @RequestParam String username, @RequestParam String password,
                            @ModelAttribute("loggedInUser") Benutzer loggedInUser) {
        if (benutzerService.testLogin(username, password)) {
            loggedInUser.setUsername(username);
            return "redirect:/braten/liste";
        }
        String correctPassword = benutzerService.getPassword(username);
        String hint = "Hinweis: Das korrekte Passwort für " + username + " ist " + correctPassword;
        m.addAttribute("passwordHint", hint);
        return "login";
    }

}