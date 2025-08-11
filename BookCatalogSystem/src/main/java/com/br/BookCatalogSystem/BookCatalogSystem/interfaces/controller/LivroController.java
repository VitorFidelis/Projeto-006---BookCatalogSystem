package com.br.BookCatalogSystem.BookCatalogSystem.interfaces.controller;
import com.br.BookCatalogSystem.BookCatalogSystem.application.usecase.*;
import com.br.BookCatalogSystem.BookCatalogSystem.interfaces.dto.LivroRequest;
import com.br.BookCatalogSystem.BookCatalogSystem.interfaces.dto.LivroResponse;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    private final UpdateLivroUseCase updateLivroUseCase;
    private final FindLivroUseCase findLivroUseCase;
    private final FindLivrosUseCase findLivrosUseCase;

    /**
     * <h1>Construtor<h1/>
     * <p>
     *     Faz a injeção de dependencia dos casos de uso;</br>
     * <p/>
     * @param createLivroUsecCase -> caso de uso para criação de um registro;
     * @param updateLivroUseCase -> caso de uso para atualização de informações de um registro;
     * @param deleteLivroUseCase -> caso de uso para deleção de um registro na base de dados;
     * @param findLivroUseCase -> caso de uso para buscar um registro por ID;
     * @param findLivrosUseCase -> caso de uso para uma busca paginada dos registro na base de dados;
     */
    public LivroController(
            final CreateLivroUseCase createLivroUsecCase,
            final DeleteLivroUseCase deleteLivroUseCase,
            final UpdateLivroUseCase updateLivroUseCase,
            final FindLivroUseCase findLivroUseCase,
            final FindLivrosUseCase findLivrosUseCase
    ) {
        this.createLivroUsecCase = createLivroUsecCase;
        this.deleteLivroUseCase = deleteLivroUseCase;
        this.updateLivroUseCase = updateLivroUseCase;
        this.findLivroUseCase = findLivroUseCase;
        this.findLivrosUseCase = findLivrosUseCase;
    }

    /**
     * <h1>Metodo createLivro<h1/>
     * <p>
     *     Esse metodo é responsavel por criar o registro do livro na base de dados
     *     com base em um DTO, onde recebe as informmações de titulo, autor e isbn
     *     no copor em formato json;</br>
     *     Ex: https://localhost:8080/livros
     * <p/>
     * @param input -> Recebe o json no corpo com os campos titulo, autor e isbn
     * @return -> retorna status code(200) e no copor não retorna nada
     */
    @PostMapping
    public ResponseEntity<Void> createLivro(
            @RequestBody final @Valid LivroRequest input
    ) {
        this.createLivroUsecCase.execute(input);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    /**
     * <h1>Metodo deleteLivro()<h1/>
     * <p>
     *     Esse metodo é responsavel por deletar o registro da base de dados
     *     com base no ID passado na URL.</br>
     *     Ex: https://localhost:8080/livros/{id}
     * <p/>
     * @param inputId -> Recebe como parametro na URL o ID
     * @return -> retorna status code(200) e no copor não retorna nada
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivro(
            @PathVariable ("id") final UUID inputId
    ) {
        this.deleteLivroUseCase.execute(inputId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    /**
     * <h1>Metodo updateLivro()<h1/>
     * <p>
     *     Esse metodo é responsavel por atualizar os dados de um registro,
     *     sendo necessarios passar o ID na URL e passar os novos dados
     *     do registro no corpo em formato json.</br>
     *     Ex: https://localhost:8080/livros/{id}
     * <p/>
     * @param inputId -> Recebe como parametro na URL o ID
     * @param input -> Recebe como parametro no corpo o json com os novos dados
     * @return -> retorna status code(202) e no copor as informações do registro
     */
    @PutMapping("/{id}")
    public ResponseEntity<LivroResponse> updateLivro(
            @PathVariable("id") final UUID inputId,
            @RequestBody final LivroRequest input
    ) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(this.updateLivroUseCase.execute(inputId, input));
    }

    /**
     * <h1>Metodo findLivroById()<h1/>
     * <p>
     *     Esse metodo é responsavel por retornar 1 registro de livro, com base
     *     no ID especificado na URL.</br>
     *     Ex: https://localhost:8080/livros/{id}
     * <p/>
     * @param inputId -> Recebe como parametro na URL o ID
     * @return -> retorna status code(200) e no copor as informações do registro
     */
    @GetMapping("/{id}")
    public ResponseEntity<LivroResponse> findLivroById(
            @PathVariable("id") final UUID inputId
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.findLivroUseCase.execute(inputId));
    }

    /**
     * <h1>Metodo findAllLivros()<h1/>
     * <p>
     *     Esse metodo é responsavel por retornar uma lista com todos os livros cadastrados no
     *     banco de dados, e junto com ele é utilizado uma biblioteca(Pageable), onde atraves
     *     dela conseguimos executar uma busca paginada e ordenada de maneira simples, contendo
     *     mais alguns outras formas de manipulação;</br>
     *     No caso desse metodo esta definido atraves da anotação @PageableDefault, que por
     *     padrão se não for especificado nenhum parametro na URL sera trago 3 registros e
     *     ordenados por titulo;</br>
     *     Obs: O padrão sem anotação @PageableDefault, é retonar 20 registros;</br>
     *     Ex: http://localhost8080/livros?sort=titulo&size=3&page=0, mas podemos alterar
     *     para http://localhost8080/livros?sort=isbn,desc&size=10&page=1;
     * <p/>
     * @param pageable -> Recebe como parametro a biblioteca Pageable,
     *                 para um retorno paginado, de 3 registros e ordenado por titulo;
     * @return -> retorna status code(200) e uma lista de Livros do tipo DTO;
     */
    @GetMapping
    public ResponseEntity<Page<LivroResponse>> findAllLivros(
             @PageableDefault(size = 3, sort = {"titulo"}) final Pageable pageable
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.findLivrosUseCase.execute(pageable));
    }
}
