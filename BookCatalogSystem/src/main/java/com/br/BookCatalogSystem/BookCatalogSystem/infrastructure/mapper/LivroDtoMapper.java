package com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.mapper;

import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.Livro;
import com.br.BookCatalogSystem.BookCatalogSystem.interfaces.dto.CreateLivroDto;
import com.br.BookCatalogSystem.BookCatalogSystem.interfaces.dto.LivroRequest;
import com.br.BookCatalogSystem.BookCatalogSystem.interfaces.dto.LivroResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Classe utilitária responsável pela conversão entre objetos de transferência de dados (DTOs)
 * e o modelo de domínio {@link  Livro}. Atua como ponte entre a camada de apresentação (controller)
 * e a lógica de negócios, mantendo o encapsulamento e separação de responsabilidades.
 */
@Component
public class LivroDtoMapper {

    /**
     * <h1>Metodo toDomain.<h1/>
     * <p>
     * Converte um objeto LivroRequest (DTO de entrada) em uma entidade de domínio Livro.
     * Esse método é responsável por mapear os dados recebidos da API para o modelo interno
     * da aplicação, separando a estrutura de entrada da lógica de negócios.
     * <p/>
     * @param livroRequest -> Objeto contendo os dados recebidos na requisição HTTP.
     * @return -> Instância da entidade Livro pronta para ser usada no domínio (ex: salvar, validar, etc).
     */
    public CreateLivroDto toCreateLivroDto(final LivroRequest livroRequest) {
        return new CreateLivroDto(
                livroRequest.titulo(),
                livroRequest.autor(),
                livroRequest.isbn()
        );
    }

    /**
     * <h1>Metodo livroResponde.<h1/>
     * <p>
     * Converte a entidade de domínio Livro em um DTO de resposta LivroResponse.
     * Esse método é usado para preparar os dados que serão enviados ao cliente via API,
     * extraindo apenas as informações necessárias (título, autor e ISBN).
     * <p/>
     * @param livro -> Entidade de domínio contendo os dados do livro.
     * @return -> Objeto LivroResponse com os dados formatados para resposta HTTP.
     */
    public LivroResponse toLivroResponse(final Livro livro) {
        return new LivroResponse(
                livro.getTitulo(),// TITULO do Dominio
                livro.getAutor(),// AUTOR do Dominio
                livro.getIsbn() // ISBN do Dominio
        );
    }

    /**
     * <h1>Metodo listaLivrosResponse.<h1/>
     * <p>
     * Converte uma lista de entidades de domínio Livro em uma lista de DTOs de resposta.
     * Cada objeto Livro é transformado em um ListaLivrosResponse contendo os campos:
     * ID, título, autor e ISBN. Esse método é útil para retornar dados de listagens na API.
     * <p/>
     * @param livroPage -> Lista de objetos do modelo de domínio Livro.
     * @return -> Lista de DTOs ListaLivrosResponse prontos para envio na resposta HTTP.
     */
    public Page<LivroResponse> listaLivrosResponse(Page<Livro> livroPage) {
        return livroPage.map(LivroResponse::new);
    }
}
