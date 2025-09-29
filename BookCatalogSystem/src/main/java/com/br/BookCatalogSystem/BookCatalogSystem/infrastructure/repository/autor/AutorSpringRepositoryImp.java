package com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.repository.autor;

import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.autor.AutorModel;
import com.br.BookCatalogSystem.BookCatalogSystem.domain.repository.autor.AutorRepository;
import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.mapper.autor.AutorMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AutorSpringRepositoryImp implements AutorRepository {

    private final AutorSpringRepository autorSpringRepository;
    private final AutorMapper autorMapper;

    public AutorSpringRepositoryImp(
            final AutorSpringRepository autorSpringRepository,
            final AutorMapper autorMapper
    ) {
        this.autorSpringRepository = autorSpringRepository;
        this.autorMapper = autorMapper;
    }

    @Override
    public AutorModel save(final AutorModel autorModel) {
        var autorEntity = this.autorMapper.toAutorEntityInfra(autorModel);
        return this.autorMapper.toAutorModelDomain(this.autorSpringRepository.save(autorEntity));
    }

    @Override
    public AutorModel update(final AutorModel autorModel) {
        var autorEntity = this.autorMapper.toAutorEntityInfra(autorModel);
        return this.autorMapper.toAutorModelDomain(this.autorSpringRepository.save(autorEntity));
    }

    @Override
    public AutorModel deactivate(final UUID id) {
        var autorEntity = this.autorSpringRepository.findById(id).get();
        return this.autorMapper.toAutorModelDomain(autorEntity);
    }

    @Override
    public AutorModel reactivate(final UUID id) {
        var autorEntity = this.autorSpringRepository.getReferenceById(id);
        return this.autorMapper.toAutorModelDomain(autorEntity);
    }

    @Override
    public AutorModel findById(final UUID id) {
        var autorEntity = this.autorSpringRepository.findById(id).get();
        return this.autorMapper.toAutorModelDomain(autorEntity);
    }

    @Override
    public Page<AutorModel> findAll(Pageable pageable) {
        var autorEntityPage = this.autorSpringRepository.findAll(pageable);
        return this.autorMapper.toAutorModelPage(autorEntityPage);
    }
}
