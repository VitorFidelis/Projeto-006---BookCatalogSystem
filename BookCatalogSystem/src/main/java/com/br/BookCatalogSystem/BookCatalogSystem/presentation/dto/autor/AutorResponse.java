package com.br.BookCatalogSystem.BookCatalogSystem.presentation.dto.autor;
import com.br.BookCatalogSystem.BookCatalogSystem.presentation.dto.autor.contato.DadosContatoAutorDetalhadoDto;
import com.br.BookCatalogSystem.BookCatalogSystem.presentation.dto.autor.endereco.DadosEnderecoAutorDetalhadoDto;

public record AutorResponse(
        String nome,
        String sobrenome,
        String cpf,
        DadosContatoAutorDetalhadoDto dadosContatoAutorDetalhadoDto,
        DadosEnderecoAutorDetalhadoDto dadosEnderecoAutorDetalhadoDto
) {

}
