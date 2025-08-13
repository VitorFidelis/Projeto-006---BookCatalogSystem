package com.br.BookCatalogSystem.BookCatalogSystem.application.usecase;

import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.mapper.LivroDtoMapper;
import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.repository.LivroRepositoryImp;
import com.br.BookCatalogSystem.BookCatalogSystem.interfaces.dto.ListarLivrosDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FindLivrosAtivosUseCase {
    private final LivroRepositoryImp livroRepositoryImp;
    private final LivroDtoMapper livroDtoMapper;

    public FindLivrosAtivosUseCase(
            final LivroRepositoryImp livroRepositoryImp,
            final LivroDtoMapper livroDtoMapper
    ) {
        this.livroRepositoryImp = livroRepositoryImp;
        this.livroDtoMapper = livroDtoMapper;
    }

    public Page<ListarLivrosDto> execute(Pageable pageable) {
        var pageLivroModele = this.livroRepositoryImp.findAllLivrosAtivos(pageable);
        return this.livroDtoMapper.listaLivrosResponse(pageLivroModele);
    }
}
