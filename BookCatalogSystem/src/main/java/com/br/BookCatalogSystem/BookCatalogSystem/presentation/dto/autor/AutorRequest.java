package com.br.BookCatalogSystem.BookCatalogSystem.presentation.dto.autor;
import com.br.BookCatalogSystem.BookCatalogSystem.presentation.dto.autor.contato.ContatoAutorRequest;
import com.br.BookCatalogSystem.BookCatalogSystem.presentation.dto.autor.endereco.EnderecoAutorRequest;

public record AutorRequest(
        String nome,
        String sobrenome,
        String cpf,
        ContatoAutorRequest contatoAutorRequest,
        EnderecoAutorRequest enderecoAutorRequest
) {

}
