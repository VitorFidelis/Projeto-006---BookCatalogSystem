package com.br.BookCatalogSystem.BookCatalogSystem.application.usecase;

import com.br.BookCatalogSystem.BookCatalogSystem.application.exception.NaoEncontradoException;
import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.Livro;
import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.repository.LivroRepositoryImp;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FindLivroUseCase {

    private final LivroRepositoryImp livroRepositoryImp;

    public FindLivroUseCase(LivroRepositoryImp livroRepositoryImp) {
        this.livroRepositoryImp = livroRepositoryImp;
    }

    public Livro findLivro(UUID inputId) {
        try {
            return this.livroRepositoryImp.findById(inputId);
        } catch (RuntimeException exception) {
            throw new NaoEncontradoException(exception.getMessage());
        }
    }
}
