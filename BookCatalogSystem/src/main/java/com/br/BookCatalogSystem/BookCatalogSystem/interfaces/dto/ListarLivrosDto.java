package com.br.BookCatalogSystem.BookCatalogSystem.interfaces.dto;

import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.Livro;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ListarLivrosDto (
        @NotNull(message = "the ID field cannot be changed")
        UUID id,
        String autor,
        String isbn,
        String titulo,
        @NotNull
        Boolean ativo
){
    public ListarLivrosDto(Livro livro) {
        this(livro.getId(),livro.getAutor(),livro.getIsbn(),livro.getTitulo(), livro.getAtivo());
    }
}
