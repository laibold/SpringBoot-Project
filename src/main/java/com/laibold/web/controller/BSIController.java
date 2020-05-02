package com.laibold.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/bsi")
public class BSIController {

    @GetMapping
    public String bsi_get(Model m){
        return "bsi";
    }

    @PostMapping
    public String bsi_post(Model m, @RequestParam int kgroesse, @RequestParam int sgroesse, @RequestParam int semzahl){
        int bsi = 100 * kgroesse / sgroesse * semzahl;
        m.addAttribute("bsi", bsi);
        return "bsi";
    }

}