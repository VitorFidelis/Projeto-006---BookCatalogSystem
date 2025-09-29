package com.br.BookCatalogSystem.BookCatalogSystem.presentation.dto.autor.contato;
import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.autor.ContatoAutorModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UpdateContatoAutorDto(
        @Email @NotBlank
        String email,

        @NotBlank
        String telefone
) {
    public UpdateContatoAutorDto(ContatoAutorModel contatoAutorModel) {
        this(
                contatoAutorModel.getEmail(),
                contatoAutorModel.getTelefone()
        );
    }
}
