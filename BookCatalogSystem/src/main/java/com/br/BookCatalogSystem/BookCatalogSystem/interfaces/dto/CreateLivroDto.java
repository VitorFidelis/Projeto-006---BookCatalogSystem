package com.br.BookCatalogSystem.BookCatalogSystem.interfaces.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CreateLivroDto (
        @NotBlank(message = "TITLE field cannot be a null request")
        @Pattern(regexp = "^[A-Za-zÀ-ÿ\\s]+$", message = "The TITULO must contain only letters")
        String titulo,

        @NotBlank(message = "Author field cannot be a null request")
        @Pattern(regexp = "^[A-Za-zÀ-ÿ\\s]+$", message = "The AUTOR must contain only letters")
        String autor,

        @NotBlank(message = "ISBN field cannot be a null request")
        String isbn
){
}
