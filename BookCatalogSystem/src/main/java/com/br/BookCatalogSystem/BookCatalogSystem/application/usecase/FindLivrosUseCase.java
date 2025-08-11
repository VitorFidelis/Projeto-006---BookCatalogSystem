package com.br.BookCatalogSystem.BookCatalogSystem.application.usecase;

import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.Livro;
import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.mapper.LivroDtoMapper;
import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.repository.LivroRepositoryImp;
import com.br.BookCatalogSystem.BookCatalogSystem.interfaces.dto.LivroResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindLivrosUseCase {

    private final LivroRepositoryImp livroRepositoryImp;
    private final LivroDtoMapper livroDtoMapper;

    public FindLivrosUseCase(
            final LivroRepositoryImp livroRepositoryImp,
            final LivroDtoMapper livroDtoMapper
    ) {
        this.livroRepositoryImp = livroRepositoryImp;
        this.livroDtoMapper = livroDtoMapper;
    }

    public List<LivroResponse> execute(Pageable pageable) {
        var listDomainLivro = this.livroRepositoryImp.findAll(pageable);
        return this.livroDtoMapper.listaLivrosResponse(listDomainLivro);
    }
}
