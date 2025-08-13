package com.br.BookCatalogSystem.BookCatalogSystem.application.usecase;

import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.Livro;
import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.mapper.LivroDtoMapper;
import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.mapper.LivroMapper;
import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.repository.LivroRepositoryImp;

import com.br.BookCatalogSystem.BookCatalogSystem.interfaces.dto.CreateLivroDto;
import com.br.BookCatalogSystem.BookCatalogSystem.interfaces.dto.LivroRequest;
import org.springframework.stereotype.Service;

@Service
public class CreateLivroUseCase {

    private final LivroRepositoryImp livroRepositoryImp;
    private final LivroDtoMapper livroDtoMapper;
    private final LivroMapper livroMapper;

    public CreateLivroUseCase(
            final LivroRepositoryImp livroRepositoryImp,
            final LivroDtoMapper livroDtoMapper,
            final LivroMapper livroMapper
    ) {
        this.livroRepositoryImp = livroRepositoryImp;
        this.livroDtoMapper = livroDtoMapper;
        this.livroMapper = livroMapper;
    }

    /**
     * Metodo de inserir o livro.
     * @param livroRequest -> recebe DTO como parametro;
     * */
    public void execute(LivroRequest livroRequest) {
        Livro livro = new Livro();

        livro.setAutor(livroRequest.autor());
        livro.setIsbn(livroRequest.isbn());
        livro.setTitulo(livroRequest.titulo());

        this.livroRepositoryImp.save(livro);
    }
}
