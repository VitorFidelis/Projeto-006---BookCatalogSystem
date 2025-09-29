package com.br.BookCatalogSystem.BookCatalogSystem.presentation.dto.autor.endereco;

public record EnderecoAutorRequest(
        String rua,
        int numero,
        String bairro,
        String cidade,
        String estado,
        String cep
) {
}
