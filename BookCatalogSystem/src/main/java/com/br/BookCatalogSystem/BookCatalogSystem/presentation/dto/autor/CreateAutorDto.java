package com.br.BookCatalogSystem.BookCatalogSystem.presentation.dto.autor;

import com.br.BookCatalogSystem.BookCatalogSystem.presentation.dto.autor.contato.CreateContatoAutorDto;
import com.br.BookCatalogSystem.BookCatalogSystem.presentation.dto.autor.endereco.CreateEnderecoAutorDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateAutorDto(
        @NotBlank
        String nome,

        @NotBlank
        String sobrenome,

        @NotBlank
        String cpf,

        @JsonProperty("contato") @NotNull
        CreateContatoAutorDto createContatoAutorDto,

        @JsonProperty("endereco") @NotNull
        CreateEnderecoAutorDto createEnderecoAutorDto
) {

}
