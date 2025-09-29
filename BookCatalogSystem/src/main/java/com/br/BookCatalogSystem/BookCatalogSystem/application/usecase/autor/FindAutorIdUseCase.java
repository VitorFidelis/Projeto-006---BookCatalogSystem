package com.br.BookCatalogSystem.BookCatalogSystem.application.usecase.autor;

import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.autor.AutorModel;
import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.repository.autor.AutorSpringRepositoryImp;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FindAutorIdUseCase {

    private final AutorSpringRepositoryImp autorSpringRepositoryImp;

    public FindAutorIdUseCase(final AutorSpringRepositoryImp autorSpringRepositoryImp) {
        this.autorSpringRepositoryImp = autorSpringRepositoryImp;
    }

    public AutorModel execute(final UUID uuid) {
        return this.autorSpringRepositoryImp.findById(uuid);
    }
}
