package com.br.BookCatalogSystem.BookCatalogSystem.application.usecase.autor;

import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.autor.AutorModel;
import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.mapper.autor.AutorMapper;
import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.repository.autor.AutorSpringRepositoryImp;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReactivateAutorUserCase {
    private final AutorSpringRepositoryImp autorSpringRepositoryImp;
    private final AutorMapper autorMapper;

    public ReactivateAutorUserCase(
            final AutorSpringRepositoryImp autorSpringRepositoryImp,
            final AutorMapper autorMapper
    ) {
        this.autorSpringRepositoryImp = autorSpringRepositoryImp;
        this.autorMapper = autorMapper;
    }

    public void execute(final UUID uuid) {
        var autorModel = this.autorSpringRepositoryImp.reactivate(uuid);
        if (autorModel.getAtivo().booleanValue() == false) {
            autorModel.setAtivo(true);
        }
        this.autorSpringRepositoryImp.save(autorModel);
    }
}
