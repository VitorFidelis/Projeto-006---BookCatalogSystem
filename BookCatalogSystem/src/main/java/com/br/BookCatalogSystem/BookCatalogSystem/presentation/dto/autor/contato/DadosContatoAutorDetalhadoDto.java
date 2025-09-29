package com.br.BookCatalogSystem.BookCatalogSystem.presentation.dto.autor.contato;

import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.autor.ContatoAutorModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DadosContatoAutorDetalhadoDto(
        @NotNull
        Long id,

        @NotNull @Email
        String email,

        @NotNull
        String telefone
) {
    public DadosContatoAutorDetalhadoDto(ContatoAutorModel contatoAutorModel) {
        this(
                contatoAutorModel.getId(),
                contatoAutorModel.getEmail(),
                contatoAutorModel.getTelefone()
        );
    }
}
