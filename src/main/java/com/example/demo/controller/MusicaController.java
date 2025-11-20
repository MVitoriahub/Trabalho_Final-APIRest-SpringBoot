package com.example.demo.controller;

import com.example.demo.model.entity.Musica;
import com.example.demo.model.service.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    private MusicaService musicaService;

    @Autowired
    public MusicaController(MusicaService musicaService) {
        this.musicaService = musicaService;
    }

    @PostMapping("/nova")
    public ResponseEntity<?> novaMusica(@RequestBody Musica musica) {
        try {
            musicaService.novaMusica(musica);
            return ResponseEntity.status(201).body(true);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Musica>> getMusicas() {
        List<Musica> musicas = musicaService.getMusicas();
        return ResponseEntity.ok(musicas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Musica> getMusicaPorId(@PathVariable("id") Long id) {
        try {
            Musica musica = musicaService.getMusicaPorId(id);
            return ResponseEntity.ok(musica);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Musica>> buscarMusicas(@RequestParam("nome") String nome) {
        List<Musica> musicasEncontradas = musicaService.buscarMusicas(nome);

        return ResponseEntity.ok(musicasEncontradas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> atualizarMusica(
            @PathVariable Long id,
            @RequestBody Musica dadosNovos) {

        try {
            musicaService.atualizarMusica(id, dadosNovos);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(false);
        }
    }

    @DeleteMapping("/apagar/{id}")
    public ResponseEntity<?> apagarMusica(@PathVariable("id") Long id) {
        try {
            musicaService.apagarMusica(id);
            return ResponseEntity.ok(true);
        } catch (Exception e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
