package com.laibold.web.controller;

import com.laibold.web.service.BenutzerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

    BenutzerService benutzerService;

    @GetMapping("")
    public String loginGet(Model m) {
        return "login";
    }

    @PostMapping("")
    public String loginPost(Model m, @RequestParam String username, @RequestParam String password) {
        if (benutzerService.testLogin(username, password)) {
            return "redirect:/angebot/liste";
        }
        String correctPassword = benutzerService.getPassword(username);
        String hint = "Hinweis: Das korrekte Passwort für " + username + " ist " + correctPassword;
        m.addAttribute("passwordHint", hint);
        return "login";
    }

}