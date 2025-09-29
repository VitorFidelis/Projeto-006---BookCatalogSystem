package com.br.BookCatalogSystem.BookCatalogSystem.presentation.dto.autor;

import com.br.BookCatalogSystem.BookCatalogSystem.presentation.dto.autor.contato.DadosContatoAutorDetalhadoDto;
import com.br.BookCatalogSystem.BookCatalogSystem.presentation.dto.autor.endereco.DadosEnderecoAutorDetalhadoDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DadosAutorDetalhadoDto(
        @NotNull
        UUID id,

        Boolean ativo,

        @NotNull
        String nome,

        @NotNull
        String sobrenome,

        @NotNull
        String cpf,

        @JsonProperty("contato") @NotNull
        DadosContatoAutorDetalhadoDto dadosContatoAutorDetalhadoDto,

        @JsonProperty("endereco") @NotNull
        DadosEnderecoAutorDetalhadoDto dadosEnderecoAutorDetalhadoDto
) {

}
