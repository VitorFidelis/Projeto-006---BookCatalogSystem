package com.br.BookCatalogSystem.BookCatalogSystem.application.usecase;

import com.br.BookCatalogSystem.BookCatalogSystem.application.exception.NaoEncontradoException;
import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.repository.LivroRepositoryImp;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteLivroUseCase {

    private final LivroRepositoryImp livroRepositoryImp;

    public DeleteLivroUseCase(LivroRepositoryImp livroRepositoryImp) {
        this.livroRepositoryImp = livroRepositoryImp;
    }

    /**
     * Metodo DeleteLivro
     * recebe ID do tipo UUID como parametro;
     * Faz uma validação try/catch para validar se o ID informado existe na base de dados;
     * se não for laçada uma exceção ele executa a deleção com base no ID passado como parametro;
     * não retorna nada;
     * @param inputId -> UUID do livro;
     * */
    public void execute(UUID inputId) {
        try {
            var validaId = this.livroRepositoryImp.findById(inputId);

        }catch (RuntimeException exception){
            throw new NaoEncontradoException("iD não encotrado: " + exception.getMessage());
        }
        this.livroRepositoryImp.delete(inputId);
    }
}
