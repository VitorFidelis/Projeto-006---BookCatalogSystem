package com.br.BookCatalogSystem.BookCatalogSystem.application.usecase;

import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.repository.LivroRepositoryImp;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeactivateLivroUseCase {
    private final LivroRepositoryImp livroRepositoryImp;

    public DeactivateLivroUseCase(LivroRepositoryImp livroRepositoryImp) {
        this.livroRepositoryImp = livroRepositoryImp;
    }

    public void execute(UUID inputId) {
        this.livroRepositoryImp.deactivate(inputId);
    }
}
