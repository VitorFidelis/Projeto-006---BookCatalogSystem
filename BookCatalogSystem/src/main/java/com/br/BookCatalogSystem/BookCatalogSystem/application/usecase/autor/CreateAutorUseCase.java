package com.br.BookCatalogSystem.BookCatalogSystem.application.usecase.autor;

import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.autor.AutorModel;
import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.autor.ContatoAutorModel;
import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.autor.EnderecoAutorModel;

import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.repository.autor.AutorSpringRepositoryImp;

import com.br.BookCatalogSystem.BookCatalogSystem.presentation.dto.autor.CreateAutorDto;

import org.springframework.stereotype.Service;

@Service
public class CreateAutorUseCase {

    private final AutorSpringRepositoryImp autorSpringRepositoryImp;

    public CreateAutorUseCase(
            final AutorSpringRepositoryImp autorSpringRepositoryImp
    ) {
        this.autorSpringRepositoryImp = autorSpringRepositoryImp;
    }

    public AutorModel execute(final CreateAutorDto createAutorDto) {
        AutorModel autorModel = new AutorModel();
        ContatoAutorModel contatoAutorModel = new ContatoAutorModel();
        EnderecoAutorModel enderecoAutorModel = new EnderecoAutorModel();

        autorModel.setNome(createAutorDto.nome());
        autorModel.setSobrenome(createAutorDto.sobrenome());
        autorModel.setCpf(createAutorDto.cpf());

        contatoAutorModel.setEmail(createAutorDto.createContatoAutorDto().email());
        contatoAutorModel.setTelefone(createAutorDto.createContatoAutorDto().telefone());

        enderecoAutorModel.setRua(createAutorDto.createEnderecoAutorDto().rua());
        enderecoAutorModel.setNumero(createAutorDto.createEnderecoAutorDto().numero());
        enderecoAutorModel.setBairro(createAutorDto.createEnderecoAutorDto().bairro());
        enderecoAutorModel.setCidade(createAutorDto.createEnderecoAutorDto().cidade());
        enderecoAutorModel.setEstado(createAutorDto.createEnderecoAutorDto().estado());
        enderecoAutorModel.setCep(createAutorDto.createEnderecoAutorDto().cep());

        autorModel.setContatoAutorModel(contatoAutorModel);
        autorModel.setEnderecoAutorModel(enderecoAutorModel);

        return this.autorSpringRepositoryImp.save(autorModel);
    }
}
