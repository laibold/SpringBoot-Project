package com.laibold.web.service;

import com.laibold.web.model.Braten;
import com.laibold.web.model.benutzer.Benutzer;
import com.laibold.web.model.exception.BratenServiceException;
import com.laibold.web.persistence.benutzer.BenutzerRepository;
import com.laibold.web.persistence.braten.BratenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BratenServiceImpl implements BratenService{

    @Autowired
    BratenRepository bratenRepository;

    @Autowired
    BenutzerRepository benutzerRepository;

    @Override
    public List<Braten> getAllBraten() {
        return bratenRepository.findAll();
    }

    @Override
    public Optional<Braten> getBratenById(int id) {
        return bratenRepository.findById(id);
    }

    @Transactional
    @Override
    public Braten addBraten(String username, Braten braten) throws BratenServiceException{
        try {
            Benutzer benutzer = benutzerRepository.findByUsername(username);
            braten.setAnbieter(benutzer);
            return bratenRepository.save(braten);
        } catch (IllegalArgumentException e) {
            throw new BratenServiceException();
        }
    }

    @Override
    public void removeBraten(int id) {
        bratenRepository.deleteById(id);
    }
}
