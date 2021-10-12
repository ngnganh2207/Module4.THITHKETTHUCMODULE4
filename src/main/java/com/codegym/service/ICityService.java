package com.codegym.service;

import com.codegym.model.City;
import com.codegym.model.Nation;

import java.util.Optional;

public interface ICityService<T> {
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    void save(T t);
    void remove(Long id);
}
