package com.codegym.service;

import com.codegym.model.City;
import com.codegym.repository.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CityService implements ICityService<City>{

    @Autowired
    private ICityRepository cityRepository;

    @Override
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public void remove(Long id) {
        cityRepository.deleteById(id);
    }
}
