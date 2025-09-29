package com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.mapper.autor;

import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.autor.AutorModel;
import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.autor.ContatoAutorModel;
import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.autor.EnderecoAutorModel;
import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.entities.autor.AutorEntity;
import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.entities.autor.ContatoAutorEntity;
import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.entities.autor.EnderecoAutorEntity;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class AutorMapper {

    //Converte entidade jpa para entidade de dominio
    public AutorModel toAutorModelDomain(AutorEntity autorEntity) {
        AutorModel autorModel = new AutorModel();

        autorModel.setId(autorEntity.getId());
        autorModel.setAtivo(autorEntity.getAtivo());
        autorModel.setNome(autorEntity.getNome());
        autorModel.setSobrenome(autorEntity.getSobrenome());
        autorModel.setCpf(autorEntity.getCpf());

        autorModel.setContatoAutorModel(new ContatoAutorModel(
                autorEntity.getEnderecoAutorEntity().getId(),
                autorEntity.getContatoAutorEntity().getEmail(),
                autorEntity.getContatoAutorEntity().getTelefone()));

        autorModel.setEnderecoAutorModel(new EnderecoAutorModel(
                autorEntity.getEnderecoAutorEntity().getId(),
                autorEntity.getEnderecoAutorEntity().getRua(),
                autorEntity.getEnderecoAutorEntity().getNumero(),
                autorEntity.getEnderecoAutorEntity().getBairro(),
                autorEntity.getEnderecoAutorEntity().getCidade(),
                autorEntity.getEnderecoAutorEntity().getEstado(),
                autorEntity.getEnderecoAutorEntity().getCep()));

        return autorModel;
    }

    //Converte entidade de dominio para entidade jpa
    public AutorEntity toAutorEntityInfra(AutorModel autorModel) {
        AutorEntity autorEntity = new AutorEntity();

        autorEntity.setId(autorModel.getId());
        autorEntity.setAtivo(autorModel.getAtivo());
        autorEntity.setNome(autorModel.getNome());
        autorEntity.setSobrenome(autorModel.getSobrenome());
        autorEntity.setCpf(autorModel.getCpf());

        autorEntity.setContatoAutorEntity(new ContatoAutorEntity(
                autorModel.getContatoAutorModel().getId(),
                autorModel.getContatoAutorModel().getEmail(),
                autorModel.getContatoAutorModel().getTelefone()));

        autorEntity.setEnderecoAutorEntity(new EnderecoAutorEntity(
                autorModel.getEnderecoAutorModel().getId(),
                autorModel.getEnderecoAutorModel().getRua(),
                autorModel.getEnderecoAutorModel().getNumero(),
                autorModel.getEnderecoAutorModel().getBairro(),
                autorModel.getEnderecoAutorModel().getCidade(),
                autorModel.getEnderecoAutorModel().getEstado(),
                autorModel.getEnderecoAutorModel().getCep()
        ));

        return autorEntity;
    }

    public Page<AutorModel> toAutorModelPage(Page<AutorEntity> autorEntityPage) {
        ModelMapper modelMapper = new ModelMapper();
        Page<AutorModel> autorModelPage = modelMapper.map(autorEntityPage,Page.class);
        return autorModelPage;
    }
}
