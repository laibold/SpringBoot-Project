package com.laibold.web.controller.api;

import com.laibold.web.model.Braten;
import com.laibold.web.model.benutzer.Benutzer;
import com.laibold.web.model.exception.BenutzernameNichtVergebenException;
import com.laibold.web.model.exception.BenutzernameSchonVergebenException;
import com.laibold.web.model.exception.BratenNichtVorhandenException;
import com.laibold.web.service.BratenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/braten")
public class BratenRestApi {
    @Autowired
    BratenService bratenService;

    @GetMapping("")
    public List<Braten> allBratenGet() {
        return bratenService.getAllBraten();
    }

    @GetMapping("/{id}")
    public Braten bratenGet(@PathVariable int id) {
        return bratenService.getBratenById(id).get();
    }

    @DeleteMapping("/{id}")
    public void bratenDelete(@PathVariable int id) {
        bratenService.removeBraten(id);
    }

    @PostMapping(value = "")
    public Braten bratenPost(@RequestBody Braten newBraten, @RequestParam String username) throws BenutzernameNichtVergebenException, BratenNichtVorhandenException {
        return bratenService.addBraten(username, newBraten);
    }

}
