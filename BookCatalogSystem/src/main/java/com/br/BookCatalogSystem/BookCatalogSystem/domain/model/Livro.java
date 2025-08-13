package com.br.BookCatalogSystem.BookCatalogSystem.domain.model;

import java.util.UUID;

public class Livro {

    private UUID id;
    private String titulo;
    private String autor;
    private String isbn;
    private Boolean ativo;

    public Livro() {

    }

    public Livro(String titulo, String autor, String isbn, Boolean ativo) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.ativo = ativo;
    }

    public Livro(UUID id, String titulo, String autor, String isbn, Boolean ativo) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.ativo = ativo;
    }

    public UUID getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
