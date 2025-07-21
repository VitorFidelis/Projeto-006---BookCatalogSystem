package com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.repository;

import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.entities.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LivroSpringDataRepository extends JpaRepository<LivroEntity, UUID> {

}
