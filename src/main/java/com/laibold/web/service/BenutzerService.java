package com.laibold.web.service;

import com.laibold.web.model.benutzer.Benutzer;

public interface BenutzerService {
    boolean testLogin(String loginName, String password);
    String getPassword(String loginName);
    Benutzer registerBenutzer(Benutzer newBenutzer);
    Benutzer findBenutzer(String username);
}
