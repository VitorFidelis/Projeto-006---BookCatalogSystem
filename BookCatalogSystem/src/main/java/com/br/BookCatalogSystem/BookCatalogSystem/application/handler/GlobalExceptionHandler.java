package com.br.BookCatalogSystem.BookCatalogSystem.application.handler;

import com.br.BookCatalogSystem.BookCatalogSystem.application.exception.NaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Exceções personalizadas que trata exceções globais,
 * retornando em formato JSON ou TEXT,
 * informações sobre o erro.
 * */
@ControllerAdvice
public class GlobalExceptionHandler {

    // Handler para Bean Validation (ex: @NotNull, @Size, etc.) -> caso de uso(CreateLivroUseCase)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(final MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();// Mapa que será retornado como JSON com os campos e mensagens de erro

        // Percorre todos os erros de campo
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put("message", error.getDefaultMessage()); // Mensagem definida na anotação (ex: @NotBlank(message = "..."))
            errors.put("campo", error.getField()); // Nome do campo com erro
            errors.put("status", String.valueOf(HttpStatus.NOT_ACCEPTABLE.value()));// Status code: erro 406 em String
            errors.put("timestamp", String.valueOf(LocalDateTime.now()));// timestamp: horario da maquina em String
        });

        // Retorna o mapa como JSON com status 400
        return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
    }

    // Handler para exceção cutomizadas -> caso de uso(DeleteLivroUseCase)
    @ExceptionHandler(NaoEncontradoException.class)
    public ResponseEntity<Map<String, Object>> handleNaoEncontradoException(final NaoEncontradoException ex) {
        // Mapa com {Chave: valor} imutaveis, que retornara um JSON com informações do erro
        Map<String, Object> erros = Map.ofEntries(
                Map.entry("Não encontrado:", ex.getMessage()),//mensagem definida onde foi laçado a exceção, mais a mensagem padrão do erro
                Map.entry("status", String.valueOf(HttpStatus.NOT_FOUND.value())),// status code: pega o valor 400, transforma me string
                Map.entry("timestamp", LocalDateTime.now()) // pega a informação da horario da maquina em data/hora/minutos/segundo em formato americano
        );

        // Retorna o mapa como JSON({chave: valor})com status 400
        return new ResponseEntity<>(erros, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Map<String, Object>> handleNoSuchElementException(final NoSuchElementException ex) {
        Map<String, Object> erros = Map.ofEntries(
                Map.entry("Elemento não encontrado: ", ex.getMessage()),
                Map.entry("Status: ", String.valueOf(HttpStatus.NOT_FOUND.value())),
                Map.entry("Timestamp: ", LocalDateTime.now())
        );

        return new ResponseEntity<>(erros, HttpStatus.NOT_FOUND);
    }
}
