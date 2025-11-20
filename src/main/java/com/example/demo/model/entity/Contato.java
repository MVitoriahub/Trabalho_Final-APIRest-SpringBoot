package com.example.demo.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name= "contatos")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tipo;
    private String contato;

    public Contato() {
    }

    public Contato(Long id, String tipo, String contato) {
        this.id = id;
        this.tipo = tipo;
        this.contato = contato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
