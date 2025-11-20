package com.example.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "cantores")
public class Cantor {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String nacionalidade;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name= "perfil_id")
    private Perfil perfil;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name= "contato_id")
    private List<Contato> contatos;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "cantor_generos",
            joinColumns = @JoinColumn(name="cantor_id"),
            inverseJoinColumns = @JoinColumn(name = "genero_id")
    )
    private List<Genero> generos;
    @OneToMany(mappedBy = "cantor", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Musica> musicas = new ArrayList<>();


    public Cantor() {
    }

    public Cantor(Long id, String nome, String nacionalidade) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }

    @Override
    public String toString() {
        return "Cantor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nacionalidade='" + nacionalidade + '\'' +
                '}';
    }
}
