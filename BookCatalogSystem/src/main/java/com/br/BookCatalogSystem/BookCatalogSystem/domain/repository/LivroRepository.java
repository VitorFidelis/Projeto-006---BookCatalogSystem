package com.br.BookCatalogSystem.BookCatalogSystem.domain.repository;

import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.Livro;
import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.entities.LivroEntity;
import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.repository.LivroSpringDataRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface LivroRepository {
    void save(final Livro input);
    void delete(final UUID inputId);
    Livro update(final Livro livro);
    Livro findById(final UUID inputId);
    Page<Livro> findAll(Pageable pageable);
}
