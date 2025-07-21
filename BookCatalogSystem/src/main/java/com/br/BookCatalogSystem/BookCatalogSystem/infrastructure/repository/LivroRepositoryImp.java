package com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.repository;

import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.Livro;
import com.br.BookCatalogSystem.BookCatalogSystem.domain.repository.LivroRepository;
import org.springframework.stereotype.Repository;
import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.mapper.LivroMapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class LivroRepositoryImp implements LivroRepository {

    private final LivroSpringDataRepository livroSpringDataRepository;

    public LivroRepositoryImp(LivroSpringDataRepository livroSpringDataRepository) {

        this.livroSpringDataRepository = livroSpringDataRepository;
    }

    @Override
    public void save(Livro input) {
        var entity = LivroMapper.toLivroEntity(input);
        this.livroSpringDataRepository.save(entity);
    }

    @Override
    public void delete(UUID inputId) {
        this.livroSpringDataRepository.deleteById(inputId);
    }

    @Override
    public Livro update(Livro livro) {
        var entity = LivroMapper.toLivroEntity(livro);
        var update = this.livroSpringDataRepository.save(entity);
        return LivroMapper.toDomain(update);
    }

    @Override
    public Livro findById(UUID inputId) {
        var teste = this.livroSpringDataRepository.findById(inputId).get();
        return LivroMapper.toDomain(teste);
    }

    @Override
    public List<Livro> findAll() {
        return this.livroSpringDataRepository
                .findAll()
                .stream()
                .map(LivroMapper::toDomain)
                .collect(Collectors.toList());
    }
}
