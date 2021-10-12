package com.codegym.service;

import com.codegym.model.Nation;

public interface INationService<T>{
    Iterable<T> findAll();
}
