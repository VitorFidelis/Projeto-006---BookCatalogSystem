package com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.repository.autor;

import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.entities.autor.AutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AutorSpringRepository extends JpaRepository<AutorEntity, UUID> {

}
