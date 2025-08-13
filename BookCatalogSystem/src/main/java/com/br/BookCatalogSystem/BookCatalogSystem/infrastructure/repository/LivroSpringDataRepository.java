package com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.repository;

import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.entities.LivroEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface LivroSpringDataRepository extends JpaRepository<LivroEntity, UUID> {

    @Modifying
    @Query(value = "UPDATE livro_entity SET ativo = false WHERE id = :id", nativeQuery = true)
    void deactivate(@Param("id") UUID inputId);

    @Modifying
    @Query(value = "UPDATE livro_entity SET ativo = true WHERE id = :id", nativeQuery = true)
    void reactivate(@Param("id") UUID inputId);

    @Query(value = "SELECT id, ativo, autor, isbn, titulo FROM livro_entity WHERE ativo = true", nativeQuery = true)
    Page<LivroEntity> findAllLivrosAtivos(Pageable pageable);

}
