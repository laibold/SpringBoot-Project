package com.laibold.web.persistence.benutzer;

import com.laibold.web.model.benutzer.Benutzer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BenutzerRepository extends JpaRepository<Benutzer, Long> {
    Benutzer findByUsername(String username);
}
