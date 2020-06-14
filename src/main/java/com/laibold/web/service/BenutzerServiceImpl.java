package com.laibold.web.service;

import com.laibold.web.model.benutzer.Benutzer;
import com.laibold.web.model.exception.BenutzernameNichtVergebenException;
import com.laibold.web.model.exception.BenutzernameSchonVergebenException;
import com.laibold.web.persistence.benutzer.BenutzerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BenutzerServiceImpl implements BenutzerService {

    @Autowired
    BenutzerRepository benutzerRepository;

    @Override
    public boolean testLogin(String username, String password) {
        String correctPassword = getPassword(username);
        return password.equals(correctPassword);
    }

    @Override
    public String getPassword(String username) {
        Benutzer userFromDatabase = benutzerRepository.findByUsername(username);
        if (userFromDatabase != null) {
            return userFromDatabase.getPassword();
        }
        return username + username.length();
    }

    @Override
    public Benutzer registerBenutzer(Benutzer newBenutzer) {
        if (benutzerRepository.findByUsername(newBenutzer.getUsername()) != null) {
            throw new BenutzernameSchonVergebenException(newBenutzer.getUsername());
        }
        return benutzerRepository.save(newBenutzer);
    }

    @Override
    public Benutzer findBenutzer(String username) {
        Benutzer benutzer = benutzerRepository.findByUsername(username);
        if (benutzer == null) {
            throw new BenutzernameNichtVergebenException(username);
        }
        return benutzer;
    }
}
