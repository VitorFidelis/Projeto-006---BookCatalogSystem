package com.br.BookCatalogSystem.BookCatalogSystem.presentation.controller.autor;

import com.br.BookCatalogSystem.BookCatalogSystem.application.usecase.autor.*;
import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.mapper.autor.AutorMapperDto;
import com.br.BookCatalogSystem.BookCatalogSystem.presentation.dto.autor.CreateAutorDto;
import com.br.BookCatalogSystem.BookCatalogSystem.presentation.dto.autor.DadosAutorDetalhadoDto;

import com.br.BookCatalogSystem.BookCatalogSystem.presentation.dto.autor.UpdateAutorDto;
import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.http.ResponseEntity;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("autores")
public class AutorController {

    private final CreateAutorUseCase createAutorUseCase;
    private final AutorMapperDto autorMapperDto;
    private final FindAutorIdUseCase findAutorIdUseCase;
    private final DeactivateAutorUseCase deactivateAutorUseCase;
    private final FindAutorAllUseCase findAutorAllUseCase;
    private final ReactivateAutorUserCase reactivateAutorUserCase;
    private final UpdateAutorUseCase updateAutorUseCase;

    public AutorController(
            final CreateAutorUseCase createAutorUseCase,
            final AutorMapperDto autorMapperDto,
            final FindAutorIdUseCase findAutorIdUseCase,
            final DeactivateAutorUseCase deactivateAutorUseCase,
            final FindAutorAllUseCase findAutorAllUseCase,
            final ReactivateAutorUserCase reactivateAutorUserCase,
            final UpdateAutorUseCase updateAutorUseCase
    ) {
        this.createAutorUseCase = createAutorUseCase;
        this.autorMapperDto = autorMapperDto;
        this.findAutorIdUseCase = findAutorIdUseCase;
        this.deactivateAutorUseCase = deactivateAutorUseCase;
        this.findAutorAllUseCase = findAutorAllUseCase;
        this.reactivateAutorUserCase = reactivateAutorUserCase;
        this.updateAutorUseCase = updateAutorUseCase;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosAutorDetalhadoDto> createAutor(
            @RequestBody @Valid final CreateAutorDto createAutorDto,
            final UriComponentsBuilder uriComponentsBuilder
    ) {
        var autorModel = this.createAutorUseCase.execute(createAutorDto);
        var uri = uriComponentsBuilder.path("/autores/{id}").buildAndExpand(autorModel.getId()).toUri();
        var dto = this.autorMapperDto.toDadosAutorDetalhadoDto(autorModel);
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosAutorDetalhadoDto> findAutorId(
            @PathVariable("id") final UUID uuid
    ) {
        var autorModel = this.findAutorIdUseCase.execute(uuid);
        var dto = this.autorMapperDto.toDadosAutorDetalhadoDto(autorModel);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deactivateAutorId(
            @PathVariable("id") final UUID uuid
    ) {
        this.deactivateAutorUseCase.execute(uuid);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<DadosAutorDetalhadoDto>> findAutorAll(
            final Pageable pageable
    ) {
        var autorModelPage = this.findAutorAllUseCase.execute(pageable);
        var dto = this.autorMapperDto.toDadosAutorDetalhadoDto(autorModelPage);
        return ResponseEntity.ok().body(dto);
    }

    @PatchMapping("/reactivate/{id}")
    @Transactional
    public ResponseEntity<Void> reactivateAutorId(
            @PathVariable("id") final UUID uuid
    ) {
        this.reactivateAutorUserCase.execute(uuid);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosAutorDetalhadoDto> updateAutor(
            @PathVariable("id") final UUID uuid,
            @RequestBody @Valid final UpdateAutorDto updateAutorDto
    ) {
        var autorModel = this.updateAutorUseCase.execute(uuid, updateAutorDto);
        var dto = this.autorMapperDto.toDadosAutorDetalhadoDto(autorModel);
        return ResponseEntity.ok(dto);
    }
}