package com.br.BookCatalogSystem.BookCatalogSystem.application.usecase.autor;

import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.autor.AutorModel;
import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.mapper.autor.AutorMapper;
import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.repository.autor.AutorSpringRepositoryImp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

import org.springframework.stereotype.Service;

@Service
public class FindAutorAllUseCase {
    private final AutorSpringRepositoryImp springRepositoryImp;
    private final AutorMapper autorMapper;

    public FindAutorAllUseCase(
            final AutorSpringRepositoryImp springRepositoryImp,
            final AutorMapper autorMapper
    ) {
        this.springRepositoryImp = springRepositoryImp;
        this.autorMapper = autorMapper;
    }

    public Page<AutorModel> execute(
            @PageableDefault(
                    page = 0,
                    size = 5,
                    sort = "nome",
                    direction = Sort.Direction.ASC) final  Pageable pageable
    ) {
        return this.springRepositoryImp.findAll(pageable);
    }
}
