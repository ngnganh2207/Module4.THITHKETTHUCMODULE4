package com.codegym.repository;

import com.codegym.model.Nation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INationRepository extends CrudRepository<Nation, Long> {
}
