package com.br.BookCatalogSystem.BookCatalogSystem.application.usecase;

import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.Livro;
import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.repository.LivroRepositoryImp;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindLivrosUseCase {

    private final LivroRepositoryImp livroRepositoryImp;

    public FindLivrosUseCase(LivroRepositoryImp livroRepositoryImp) {
        this.livroRepositoryImp = livroRepositoryImp;
    }

    public List<Livro>execute() {
        return this.livroRepositoryImp.findAll();
    }
}
