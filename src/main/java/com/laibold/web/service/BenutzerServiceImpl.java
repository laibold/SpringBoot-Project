package com.laibold.web.service;

import com.laibold.web.model.benutzer.Benutzer;
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
        if (findBenutzer(newBenutzer.getUsername()) != null) {
            throw new BenutzernameSchonVergebenException();
        }
        return benutzerRepository.save(newBenutzer);
    }

    @Override
    public Benutzer findBenutzer(String username) {
        return (benutzerRepository.findByUsername(username));
    }
}
