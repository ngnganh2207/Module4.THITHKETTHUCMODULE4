package com.codegym.repository;

import com.codegym.model.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepository extends CrudRepository<City,Long> {
}
