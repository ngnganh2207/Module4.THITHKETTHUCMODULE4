package com.codegym.service;

import com.codegym.model.Nation;
import com.codegym.repository.INationRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class NationService implements INationService<Nation> {

    @Autowired
    private INationRepository nationRepository;

    @Override
    public Iterable<Nation> findAll() {
        return nationRepository.findAll();
    }
}
