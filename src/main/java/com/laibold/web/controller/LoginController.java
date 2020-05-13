package com.laibold.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("")
    public String loginGet(Model m) {
        return "login";
    }

    @PostMapping("")
    public String loginPost(Model m, @RequestParam String username, @RequestParam String password) {
        String correctPassword = username + username.length();
        if (!password.equals(correctPassword)) {
            logger.error("Failed login attempt with user {} and password {}.", username, password);
            String hint = "Hinweis: Das korrekte Passwort für " + username + " ist " + correctPassword;
            m.addAttribute("passwordHint", hint);
        }
            return "login";
    }

}