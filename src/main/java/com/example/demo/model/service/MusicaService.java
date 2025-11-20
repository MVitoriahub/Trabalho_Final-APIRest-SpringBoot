package com.example.demo.model.service;

import com.example.demo.model.entity.Musica;

import java.util.List;

public interface MusicaService {
    Boolean novaMusica(Musica musica) throws Exception;
    List<Musica> getMusicas();
    Musica getMusicaPorId(Long id) throws Exception;
    List<Musica> buscarMusicas(String nome);
    void atualizarMusica(Long id, Musica dadosNovos) throws Exception;
    Boolean apagarMusica(Long id) throws Exception;
}
