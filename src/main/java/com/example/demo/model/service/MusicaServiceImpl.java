package com.example.demo.model.service;

import com.example.demo.model.entity.Cantor;
import com.example.demo.model.entity.Musica;
import com.example.demo.model.repository.MusicaRepository;
import com.example.demo.model.repository.CantorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicaServiceImpl implements MusicaService {

    @Autowired
    private MusicaRepository repository;

    @Autowired
    private CantorRepository cantorRepository;

    @Override
    public Boolean novaMusica(Musica musica) throws Exception {
        try {
            if (musica.getCantor() == null || musica.getCantor().getId() == null) {
                throw new Exception("É necessário informar o cantor da música.");
            }

            Cantor cantor = cantorRepository.findById(musica.getCantor().getId())
                    .orElseThrow(() -> new Exception("Cantor não encontrado."));

            musica.setCantor(cantor);

            Musica musicaSalva = repository.save(musica);

            cantor.getMusicas().add(musicaSalva);
            cantorRepository.save(cantor);

            return true;

        } catch (Exception e) {
            throw new Exception("Erro ao criar música: " + e.getMessage());
        }
    }

    @Override
    public List<Musica> getMusicas() {
        Iterable<Musica> musicas = repository.findAll();
        return (List<Musica>) musicas;
    }

    @Override
    public Musica getMusicaPorId(Long id) throws Exception {
        Optional<Musica> musicaEncontrada = repository.findById(id);

        if (musicaEncontrada.isPresent()) {
            return musicaEncontrada.get();
        } else {
            throw new Exception("Nenhuma música com este id foi encontrada");
        }
    }

    @Override
    public List<Musica> buscarMusicas(String nome) {
        Iterable<Musica> musicasEncontradas = repository.findByNomeContains(nome);
        return (List<Musica>) musicasEncontradas;
    }

    @Override
    public void atualizarMusica(Long id, Musica dadosNovos) throws Exception {
        Musica musica = repository.findById(id)
                .orElseThrow(() -> new Exception("Música não encontrada"));

        if (dadosNovos.getNome() != null) {
            musica.setNome(dadosNovos.getNome());
        }

        if (dadosNovos.getDuracao() != null) {
            musica.setDuracao(dadosNovos.getDuracao());
        }

        if (dadosNovos.getAno() != null) {
            musica.setAno(dadosNovos.getAno());
        }

        if (dadosNovos.getCantor() != null && dadosNovos.getCantor().getId() != null) {

            Cantor cantor = cantorRepository.findById(dadosNovos.getCantor().getId())
                    .orElseThrow(() -> new Exception("Cantor informado não existe."));

            musica.setCantor(cantor);
        }

        repository.save(musica);
    }

    @Override
    public Boolean apagarMusica(Long id) throws Exception {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Nenhuma música com esse id foi encontrada");
        }

        return true;
    }
}

