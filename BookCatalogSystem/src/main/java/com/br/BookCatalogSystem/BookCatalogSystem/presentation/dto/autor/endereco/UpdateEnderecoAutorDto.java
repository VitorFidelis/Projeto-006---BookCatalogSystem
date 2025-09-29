package com.br.BookCatalogSystem.BookCatalogSystem.presentation.dto.autor.endereco;

import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.autor.EnderecoAutorModel;
import jakarta.validation.constraints.NotBlank;

public record UpdateEnderecoAutorDto(
        @NotBlank
        String rua,

        int numero,

        @NotBlank
        String bairro,

        @NotBlank
        String cidade,

        @NotBlank
        String estado,

        @NotBlank
        String cep
) {
    public UpdateEnderecoAutorDto (EnderecoAutorModel enderecoAutorModel) {
        this(
                enderecoAutorModel.getRua(),
                enderecoAutorModel.getNumero(),
                enderecoAutorModel.getBairro(),
                enderecoAutorModel.getCidade(),
                enderecoAutorModel.getEstado(),
                enderecoAutorModel.getCep()
        );
    }
}
