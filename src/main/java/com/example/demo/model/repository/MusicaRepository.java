package com.example.demo.model.repository;

import com.example.demo.model.entity.Musica;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicaRepository extends CrudRepository<Musica, Long> {

    public List<Musica> findByNomeContains(String nome);
}
