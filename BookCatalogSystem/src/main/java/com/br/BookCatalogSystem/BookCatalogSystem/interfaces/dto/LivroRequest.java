package com.br.BookCatalogSystem.BookCatalogSystem.interfaces.dto;

public record LivroRequest(
        String autor,
        String isbn,
        String titulo

) {
    public LivroRequest (CreateLivroDto createLivroDto) {
        this(createLivroDto.autor(), createLivroDto.isbn(), createLivroDto.titulo());
    }
}
