package com.br.BookCatalogSystem.BookCatalogSystem.presentation.dto.autor.endereco;

import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.autor.EnderecoAutorModel;
import jakarta.validation.constraints.NotNull;

public record DadosEnderecoAutorDetalhadoDto(
        @NotNull
        Long id,

        @NotNull
        String rua,

        @NotNull
        int numero,

        @NotNull
        String bairro,

        @NotNull
        String cidade,

        @NotNull
        String estado,

        @NotNull
        String cep
) {
    public DadosEnderecoAutorDetalhadoDto(EnderecoAutorModel enderecoAutorModel) {
        this(
                enderecoAutorModel.getId(),
                enderecoAutorModel.getRua(),
                enderecoAutorModel.getNumero(),
                enderecoAutorModel.getBairro(),
                enderecoAutorModel.getCidade(),
                enderecoAutorModel.getEstado(),
                enderecoAutorModel.getCep()
        );
    }
}
