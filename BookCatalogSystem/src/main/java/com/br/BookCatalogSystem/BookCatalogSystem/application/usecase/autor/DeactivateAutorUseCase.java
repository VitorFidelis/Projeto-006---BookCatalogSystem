package com.br.BookCatalogSystem.BookCatalogSystem.application.usecase.autor;
import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.repository.autor.AutorSpringRepositoryImp;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeactivateAutorUseCase {

    private final AutorSpringRepositoryImp autorSpringRepositoryImp;

    public DeactivateAutorUseCase(
            final AutorSpringRepositoryImp autorSpringRepositoryImp
    ) {
        this.autorSpringRepositoryImp = autorSpringRepositoryImp;
    }

    public void execute(final UUID uuid) {
        var autorModel = this.autorSpringRepositoryImp.deactivate(uuid);
        if (autorModel.getAtivo().booleanValue() == true){
            autorModel.setAtivo(false);
        }
        this.autorSpringRepositoryImp.save(autorModel);
    }
}
