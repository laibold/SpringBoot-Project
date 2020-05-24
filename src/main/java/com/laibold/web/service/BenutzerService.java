package com.laibold.web.service;

public interface BenutzerService {
    boolean testLogin(String loginName, String password);
    String getPassword(String loginName);
}
