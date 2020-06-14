package com.laibold.web.controller.api;

import com.laibold.web.model.benutzer.Benutzer;
import com.laibold.web.model.exception.BenutzernameSchonVergebenException;
import com.laibold.web.service.BenutzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/benutzer")
public class BenutzerRestApi {
    @Autowired
    BenutzerService benutzerService;

    @GetMapping("/{username}")
    public Benutzer benutzerGet(@PathVariable String username) {
        return benutzerService.findBenutzer(username);
    }

    @PostMapping(value = "")
    public Benutzer benutzerPost(@RequestBody Benutzer newBenutzer) throws BenutzernameSchonVergebenException {
        return benutzerService.registerBenutzer(newBenutzer);
    }
}
