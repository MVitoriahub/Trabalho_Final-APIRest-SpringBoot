package com.example.demo.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name="perfis")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tipo;
    private String perfil;

    public Perfil() {
    }

    public Perfil(Long id, String tipo, String perfil) {
        this.id = id;
        this.tipo = tipo;
        this.perfil = perfil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}
