package com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.entities;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotNull;


import java.util.UUID;

@Entity
@Table(name = "LivroEntity")
public class LivroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length = 1000, nullable = false)
    private String titulo;

    @Column(length = 100, nullable = false)
    private String autor;

    @Column(length = 100, nullable = false)
    private String isbn;

    @Column(nullable = false)
    @NotNull
    private Boolean ativo;

    public LivroEntity() {

    }

    public LivroEntity(UUID id, String titulo, String autor, String isbn, Boolean ativo) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.ativo = true;
    }

    public UUID getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public Boolean getAtivo() {
        return ativo;
    }
}
