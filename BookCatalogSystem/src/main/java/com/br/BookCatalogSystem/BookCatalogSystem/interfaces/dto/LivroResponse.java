package com.br.BookCatalogSystem.BookCatalogSystem.interfaces.dto;

import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.Livro;

public record LivroResponse(
        String autor,
        String isbn,
        String titulo) {

    public LivroResponse (Livro livro){
        this(livro.getAutor(),livro.getIsbn(),livro.getTitulo());
    }
}
