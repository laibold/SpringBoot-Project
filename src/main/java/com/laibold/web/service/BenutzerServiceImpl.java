package com.laibold.web.service;

import org.springframework.stereotype.Service;

@Service
public class BenutzerServiceImpl implements BenutzerService {
    @Override
    public boolean testLogin(String username, String password) {
        String correctPassword = getPassword(username);
        return password.equals(correctPassword);
    }

    @Override
    public String getPassword(String username) {
        return username + username.length();
    }
}
