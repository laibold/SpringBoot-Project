package com.laibold.web.persistence.braten;

import com.laibold.web.model.Braten;
import com.laibold.web.model.benutzer.Benutzer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BratenRepository extends JpaRepository<Braten, Integer> {
    List<Braten> findByBeschreibungContainsIgnoringCase(String beschreibung);
    List<Braten> findByAnbieter(Benutzer anbieter);
}
