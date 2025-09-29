package com.br.BookCatalogSystem.BookCatalogSystem.domain.repository.autor;

import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.autor.AutorModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface AutorRepository {
    AutorModel save(final AutorModel autorModel);
    AutorModel update(final AutorModel autorModel);
    AutorModel deactivate(final UUID id);
    AutorModel reactivate(final UUID id);
    AutorModel findById(final UUID id);
    Page<AutorModel> findAll(Pageable pageable);
}
