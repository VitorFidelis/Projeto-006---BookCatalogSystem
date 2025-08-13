package com.br.BookCatalogSystem.BookCatalogSystem.interfaces.dto;

import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.Livro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CreateLivroDto (
        @NotBlank(message = "Author field cannot be a null request")
        @Pattern(regexp = "^[A-Za-zÀ-ÿ\\s]+$", message = "The AUTOR must contain only letters")
        String autor,

        @NotBlank(message = "ISBN field cannot be a null request")
        String isbn,

        @NotBlank(message = "TITLE field cannot be a null request")
        @Pattern(regexp = "^[A-Za-zÀ-ÿ\\s]+$", message = "The TITULO must contain only letters")
        String titulo
){
    public CreateLivroDto(Livro livro) {
        this(livro.getAutor(), livro.getIsbn(), livro.getTitulo());
    }
}
