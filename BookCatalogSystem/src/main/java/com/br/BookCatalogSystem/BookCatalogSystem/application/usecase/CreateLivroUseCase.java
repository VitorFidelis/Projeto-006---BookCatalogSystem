package com.br.BookCatalogSystem.BookCatalogSystem.application.usecase;

import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.Livro;
import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.repository.LivroRepositoryImp;

import org.springframework.stereotype.Service;

@Service
public class CreateLivroUseCase {

    private final LivroRepositoryImp livroRepositoryImp;

    public CreateLivroUseCase(LivroRepositoryImp livroRepositoryImp) {

        this.livroRepositoryImp = livroRepositoryImp;
    }
    /**
     * Metodo de inserir o livro.
     * @param input -> recebe livro como parametro;
     * */
    public void execute(Livro input) {
        this.livroRepositoryImp.save(input);
    }
}
