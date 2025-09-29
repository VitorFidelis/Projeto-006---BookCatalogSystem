package com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.mapper.autor;

import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.autor.EnderecoAutorModel;
import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.entities.autor.EnderecoAutorEntity;

public class EnderecoAutorMapper {

    public static EnderecoAutorModel toEnderecoModel(EnderecoAutorEntity enderecoAutorEntity) {
        return new EnderecoAutorModel(
                enderecoAutorEntity.getId(),
                enderecoAutorEntity.getRua(),
                enderecoAutorEntity.getNumero(),
                enderecoAutorEntity.getBairro(),
                enderecoAutorEntity.getCidade(),
                enderecoAutorEntity.getEstado(),
                enderecoAutorEntity.getCep()
        );
    }

    public static EnderecoAutorEntity toEnderecoEntity(EnderecoAutorModel enderecoAutorModel) {
        return new EnderecoAutorEntity(
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
