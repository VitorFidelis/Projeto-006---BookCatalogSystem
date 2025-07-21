package com.br.BookCatalogSystem.BookCatalogSystem.interfaces.controller;

import com.br.BookCatalogSystem.BookCatalogSystem.application.usecase.*;
import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.Livro;
import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.mapper.LivroDtoMapper;
import com.br.BookCatalogSystem.BookCatalogSystem.interfaces.dto.ListaLivrosResponse;
import com.br.BookCatalogSystem.BookCatalogSystem.interfaces.dto.LivroRequest;


import com.br.BookCatalogSystem.BookCatalogSystem.interfaces.dto.LivroResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final CreateLivroUseCase createLivroUsecCase;

    private final DeleteLivroUseCase deleteLivroUseCase;

    private final LivroDtoMapper livroDtoMapper;

    private final UpdateLivroUseCase updateLivroUseCase;

    private final FindLivroUseCase findLivroUseCase;

    private final FindLivrosUseCase findLivrosUseCase;

    public LivroController(
            CreateLivroUseCase createLivroUsecCase,
            DeleteLivroUseCase deleteLivroUseCase,
            LivroDtoMapper livroDtoMapper,
            UpdateLivroUseCase updateLivroUseCase,
            FindLivroUseCase findLivroUseCase,
            FindLivrosUseCase findLivrosUseCase
    ) {
        this.createLivroUsecCase = createLivroUsecCase;
        this.deleteLivroUseCase = deleteLivroUseCase;
        this.livroDtoMapper = livroDtoMapper;
        this.updateLivroUseCase = updateLivroUseCase;
        this.findLivroUseCase = findLivroUseCase;
        this.findLivrosUseCase = findLivrosUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> saveLivro(
            @RequestBody final @Valid LivroRequest input
    ) {
        Livro livro = livroDtoMapper.toDomain(input);
        this.createLivroUsecCase.execute(livro);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivro(
            @PathVariable ("id") final UUID inputId
    ) {
        this.deleteLivroUseCase.execute( inputId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroResponse> updateLivro(
            @PathVariable("id") final UUID inputId,
            @RequestBody final LivroRequest input
    ) {
        var livroUpdate = this.updateLivroUseCase.execute(inputId, input);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(this.livroDtoMapper.livroResponse(livroUpdate));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroResponse> findLivroById(
            @PathVariable("id") final UUID inputId
    ) {
        var livroId = this.findLivroUseCase.findLivro(inputId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.livroDtoMapper.livroResponse(livroId));
    }

    @GetMapping
    public ResponseEntity<List<ListaLivrosResponse>> findAllLivros(

    ) {
        var livros = this.findLivrosUseCase.execute();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.livroDtoMapper.listaLivrosResponse(livros));
    }
}
