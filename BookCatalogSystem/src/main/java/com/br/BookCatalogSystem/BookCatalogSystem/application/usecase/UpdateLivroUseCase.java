package com.br.BookCatalogSystem.BookCatalogSystem.application.usecase;

import com.br.BookCatalogSystem.BookCatalogSystem.application.exception.NaoEncontradoException;
import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.Livro;
import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.repository.LivroRepositoryImp;
import com.br.BookCatalogSystem.BookCatalogSystem.interfaces.dto.LivroRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateLivroUseCase {
    
    private final LivroRepositoryImp livroRepositoryImp;

    /**
     * Contrutor.
     * @param livroRepositoryImp -> Classe repository para manipulação das operações CRUD;
     * */
    public UpdateLivroUseCase(final LivroRepositoryImp livroRepositoryImp) {
        this.livroRepositoryImp = livroRepositoryImp;
    }

    /**
     * Metodo de update.
     * @param inputID -> recebe o UUID do livro;
     * @param input -> recebe o DTO com os campos;
     * @return -> retorna as novas informações do livro populadas;
     * @throws NaoEncontradoException -> UUID informado não enconttrado na base de dados;
     * */
    public Livro execute (final UUID inputID, final LivroRequest input) {
        try {
            var existeId = this.livroRepositoryImp.findById(inputID);

            existeId.setTitulo(input.titulo());
            existeId.setAutor(input.autor());
            existeId.setIsbn(input.isbn());

            return this.livroRepositoryImp.update(existeId);

        } catch (RuntimeException exception) {
            throw new NaoEncontradoException(exception.getMessage());
        }
    }
}
