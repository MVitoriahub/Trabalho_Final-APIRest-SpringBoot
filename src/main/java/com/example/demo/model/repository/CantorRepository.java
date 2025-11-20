package com.example.demo.model.repository;

import com.example.demo.model.entity.Cantor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CantorRepository extends CrudRepository<Cantor, Long> {
}
