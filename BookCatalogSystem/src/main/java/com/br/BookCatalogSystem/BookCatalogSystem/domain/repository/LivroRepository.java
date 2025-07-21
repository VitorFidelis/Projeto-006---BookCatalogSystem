package com.br.BookCatalogSystem.BookCatalogSystem.domain.repository;

import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.Livro;

import java.util.List;
import java.util.UUID;

public interface LivroRepository {

    void save(final Livro input);
    void delete(final UUID inputId);
    Livro update(final Livro livro);
    Livro findById(final UUID inputId);
    List<Livro> findAll();

}
