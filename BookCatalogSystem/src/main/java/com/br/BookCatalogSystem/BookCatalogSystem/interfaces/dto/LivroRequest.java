package com.br.BookCatalogSystem.BookCatalogSystem.interfaces.dto;

public record LivroRequest(
        String titulo,
        String autor,
        String isbn
) {
}
