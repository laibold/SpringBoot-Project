package com.laibold.web.service;

import com.laibold.web.model.Braten;
import com.laibold.web.model.exception.BratenServiceException;

import java.util.List;
import java.util.Optional;

public interface BratenService {
    // alle Braten-Angebote in der Datenbank
    List<Braten> getAllBraten();

    // Der Braten mit der angegebenen ID
    Optional<Braten> getBratenById(int id);

    // Uebergebenen Braten fuer in der DB anlegen bzw. aktualisieren;
    // Bei Fehler wird eigene BratenServiceException geworfen
    Braten addBraten(String username, Braten braten) throws BratenServiceException;
    
    // Braten mit der angegebenen ID loeschen
    void removeBraten(int id);
}