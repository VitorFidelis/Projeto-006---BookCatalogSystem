package com.br.BookCatalogSystem.BookCatalogSystem.interfaces.dto;


import java.util.UUID;

public record ListaLivrosResponse(
        UUID id,
        String titulo,
        String autor,
        String isbn
) {

}
