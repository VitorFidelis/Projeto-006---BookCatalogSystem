package com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.mapper.autor;

import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.autor.ContatoAutorModel;
import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.entities.autor.ContatoAutorEntity;

public class ContatoAutorMapper {

    public ContatoAutorModel toContatoAutorModel(ContatoAutorEntity contatoAutorEntity) {
        return new ContatoAutorModel(
                contatoAutorEntity.getId(),
                contatoAutorEntity.getEmail(),
                contatoAutorEntity.getTelefone()
        );
    }

    public final ContatoAutorEntity toContatoAutorEntity(ContatoAutorModel contatoAutorModel) {
        return new ContatoAutorEntity(
                contatoAutorModel.getId(),
                contatoAutorModel.getEmail(),
                contatoAutorModel.getTelefone()
        );
    }
}
