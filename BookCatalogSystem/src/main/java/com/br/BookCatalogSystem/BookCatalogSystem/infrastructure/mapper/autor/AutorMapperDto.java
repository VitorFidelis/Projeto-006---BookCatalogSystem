package com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.mapper.autor;

import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.autor.AutorModel;

import com.br.BookCatalogSystem.BookCatalogSystem.presentation.dto.autor.DadosAutorDetalhadoDto;
import com.br.BookCatalogSystem.BookCatalogSystem.presentation.dto.autor.contato.DadosContatoAutorDetalhadoDto;
import com.br.BookCatalogSystem.BookCatalogSystem.presentation.dto.autor.endereco.DadosEnderecoAutorDetalhadoDto;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class AutorMapperDto {

    public DadosAutorDetalhadoDto toDadosAutorDetalhadoDto(AutorModel autorModel) {

        return new DadosAutorDetalhadoDto(
                autorModel.getId(),
                autorModel.getAtivo(),
                autorModel.getNome(),
                autorModel.getSobrenome(),
                autorModel.getCpf(),
                new DadosContatoAutorDetalhadoDto(
                        autorModel.getContatoAutorModel().getId(),
                        autorModel.getContatoAutorModel().getEmail(),
                        autorModel.getContatoAutorModel().getTelefone()
                ),
                new DadosEnderecoAutorDetalhadoDto(
                        autorModel.getEnderecoAutorModel().getId(),
                        autorModel.getEnderecoAutorModel().getRua(),
                        autorModel.getEnderecoAutorModel().getNumero(),
                        autorModel.getEnderecoAutorModel().getBairro(),
                        autorModel.getEnderecoAutorModel().getCidade(),
                        autorModel.getEnderecoAutorModel().getEstado(),
                        autorModel.getEnderecoAutorModel().getCep()
                )
        );
    }

    public Page<DadosAutorDetalhadoDto> toDadosAutorDetalhadoDto(Page<AutorModel> autorModelPage) {
        ModelMapper modelMapper = new ModelMapper();
        Page<DadosAutorDetalhadoDto> autorDetalhadoDtoPage = modelMapper.map(autorModelPage, Page.class);
        return autorDetalhadoDtoPage;
    }
}
