package com.br.BookCatalogSystem.BookCatalogSystem.application.usecase;

import com.br.BookCatalogSystem.BookCatalogSystem.application.exception.NaoEncontradoException;
import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.Livro;
import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.mapper.LivroDtoMapper;
import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.repository.LivroRepositoryImp;
import com.br.BookCatalogSystem.BookCatalogSystem.interfaces.dto.LivroResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FindLivroUseCase {

    private final LivroRepositoryImp livroRepositoryImp;
    private final LivroDtoMapper livroDtoMapper;

    public FindLivroUseCase(
            final LivroRepositoryImp livroRepositoryImp,
            final LivroDtoMapper livroDtoMapper
    ) {
        this.livroRepositoryImp = livroRepositoryImp;
        this.livroDtoMapper = livroDtoMapper;
    }

    public LivroResponse execute(UUID inputId) {
        try {
            var livroModel  = this.livroRepositoryImp.findById(inputId);
            return this.livroDtoMapper.toLivroResponse(livroModel);
        } catch (RuntimeException exception) {
            throw new NaoEncontradoException(exception.getMessage());
        }
    }
}
