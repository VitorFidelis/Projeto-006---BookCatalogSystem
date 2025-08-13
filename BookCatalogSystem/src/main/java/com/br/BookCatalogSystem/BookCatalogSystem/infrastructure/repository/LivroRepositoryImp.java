package com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.repository;

import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.Livro;
import com.br.BookCatalogSystem.BookCatalogSystem.domain.repository.LivroRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.mapper.LivroMapper;

import java.util.UUID;

@Repository
public class LivroRepositoryImp implements LivroRepository {

    private final LivroSpringDataRepository livroSpringDataRepository;
    private final LivroMapper livroMapper;

    public LivroRepositoryImp(
            final LivroSpringDataRepository livroSpringDataRepository,
            final LivroMapper livroMapper
    ) {

        this.livroSpringDataRepository = livroSpringDataRepository;
        this.livroMapper = livroMapper;
    }

    @Override
    public void save(Livro input) {
        var entity = this.livroMapper.toLivroEntity(input);
        this.livroSpringDataRepository.save(entity);
    }

    @Override
    public void delete(UUID inputId) {
        this.livroSpringDataRepository.deleteById(inputId);
    }

    @Override
    public void deactivate(UUID inputDeactivateId) {
        this.livroSpringDataRepository.deactivate(inputDeactivateId);
    }

    @Override
    public void reactivate(UUID inputReactivateId) {
        this.livroSpringDataRepository.reactivate(inputReactivateId);
    }

    @Override
    public Livro update(Livro livro) {
        var entity = this.livroMapper.toLivroEntity(livro);
        var update = this.livroSpringDataRepository.save(entity);
        return this.livroMapper.toDomain(update);
    }

    @Override
    public Livro findById(UUID inputId) {
        var livroEntity = this.livroSpringDataRepository.findById(inputId).get();
        return this.livroMapper.toDomain(livroEntity);
    }

    @Override
    public Page<Livro> findAll(Pageable pageable) {
        var pageLivroEntity = this.livroSpringDataRepository.findAll(pageable);
        return this.livroMapper.toLivrosPageDomain(pageLivroEntity);
    }

    @Override
    public Page<Livro> findAllLivrosAtivos(Pageable pageable) {
        var pageLivroEntity = this.livroSpringDataRepository.findAllLivrosAtivos(pageable);
        return this.livroMapper.toLivrosPageDomain(pageLivroEntity);
    }
}
