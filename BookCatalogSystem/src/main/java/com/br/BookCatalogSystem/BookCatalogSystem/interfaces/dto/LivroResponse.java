package com.br.BookCatalogSystem.BookCatalogSystem.interfaces.dto;

import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.Livro;

public record LivroResponse(
        String autor,
        String isbn,
        String titulo,
        Boolean ativo

) {

    public LivroResponse (ListarLivrosDto listarLivrosDto){
        this(listarLivrosDto.autor(), listarLivrosDto.isbn(), listarLivrosDto.titulo(), listarLivrosDto.ativo());
    }
}
