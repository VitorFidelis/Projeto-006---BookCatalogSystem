package com.br.BookCatalogSystem.BookCatalogSystem.presentation.dto.autor;

import com.br.BookCatalogSystem.BookCatalogSystem.presentation.dto.autor.contato.UpdateContatoAutorDto;
import com.br.BookCatalogSystem.BookCatalogSystem.presentation.dto.autor.endereco.UpdateEnderecoAutorDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateAutorDto(
        @NotBlank
        String nome,

        @NotBlank
        String sobrenome,

        @NotBlank
        String cpf,

        @JsonProperty("contato") @NotNull
        UpdateContatoAutorDto updateContatoAutorDto,

        @JsonProperty("endereco") @NotNull
        UpdateEnderecoAutorDto updateEnderecoAutorDto
) {

}
