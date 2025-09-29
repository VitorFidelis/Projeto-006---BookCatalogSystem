package com.br.BookCatalogSystem.BookCatalogSystem.application.usecase.autor;

import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.autor.AutorModel;
import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.autor.ContatoAutorModel;
import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.autor.EnderecoAutorModel;
import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.repository.autor.AutorSpringRepositoryImp;
import com.br.BookCatalogSystem.BookCatalogSystem.presentation.dto.autor.UpdateAutorDto;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateAutorUseCase {
    private final AutorSpringRepositoryImp autorSpringRepositoryImp;

    public UpdateAutorUseCase(
            final AutorSpringRepositoryImp autorSpringRepositoryImp
    ) {
        this.autorSpringRepositoryImp = autorSpringRepositoryImp;
    }

    public AutorModel execute(
            final UUID uuid,
            final UpdateAutorDto updateAutorDto
    ) {
        var autorModel = this.autorSpringRepositoryImp.findById(uuid);

        ContatoAutorModel contatoAutorModel = new ContatoAutorModel();
        EnderecoAutorModel enderecoAutorModel = new EnderecoAutorModel();

        autorModel.setNome(updateAutorDto.nome());
        autorModel.setSobrenome(updateAutorDto.sobrenome());
        autorModel.setCpf(updateAutorDto.cpf());

        contatoAutorModel.setEmail(updateAutorDto.updateContatoAutorDto().email());
        contatoAutorModel.setTelefone(updateAutorDto.updateContatoAutorDto().telefone());

        enderecoAutorModel.setRua(updateAutorDto.updateEnderecoAutorDto().rua());
        enderecoAutorModel.setNumero(updateAutorDto.updateEnderecoAutorDto().numero());
        enderecoAutorModel.setBairro(updateAutorDto.updateEnderecoAutorDto().bairro());
        enderecoAutorModel.setCidade(updateAutorDto.updateEnderecoAutorDto().cidade());
        enderecoAutorModel.setEstado(updateAutorDto.updateEnderecoAutorDto().estado());
        enderecoAutorModel.setCep(updateAutorDto.updateEnderecoAutorDto().cep());

        autorModel.setContatoAutorModel(contatoAutorModel);
        autorModel.setEnderecoAutorModel(enderecoAutorModel);

        return this.autorSpringRepositoryImp.save(autorModel);
    }
}
