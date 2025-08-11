package com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.mapper;

import com.br.BookCatalogSystem.BookCatalogSystem.domain.model.Livro;
import com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.entities.LivroEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe utilitária que realiza a conversão entre o modelo de domínio {@link Livro}
 * e a entidade JPA {@link LivroEntity}, permitindo a separação entre as camadas
 * de domínio e persistência.
 */
@Component
public class LivroMapper {

    /**
     * <h1>Metodo toLivroEntity<h1/>
     * <p>
     *     Converte um objeto do modelo de domínio Livro para a entidade JPA LivroEntity.
     *     Esse método é utilizado para adaptar os dados da aplicação antes de persistir no banco de dados.
     * <p/>
     * @param livro Objeto do modelo de domínio Livro.
     * @return Entidade JPA LivroEntity equivalente, pronta para ser salva no banco.
     */
    public LivroEntity toLivroEntity(final Livro livro) {
        return new LivroEntity(
                livro.getId(),
                livro.getTitulo(),
                livro.getAutor(),
                livro.getIsbn()
        );
    }

    /**
     * <h1>Metodo toDomain<h1/>
     * <p>
     *     Converte uma entidade JPA LivroEntity em um objeto do modelo de domínio Livro.
     *     Esse método é utilizado para adaptar os dados vindos da camada de persistência
     *     (banco de dados) para o modelo de domínio usado na aplicação.
     * <p/>
     * @param livroEntity -> Entidade JPA representando os dados do livro no banco.
     * @return -> Objeto Livro do modelo de domínio.
     */
    public Livro toDomain(final LivroEntity livroEntity) {
        return new Livro(
                livroEntity.getId(),
                livroEntity.getTitulo(),
                livroEntity.getAutor(),
                livroEntity.getIsbn()
        );
    }

    /**
     * <h1>Metodo toLivrosPageDomain<h1/>
     * <p>
     *     Converte uma entidade JPA Page<LivroEntity> em uma lista Livro de livro.
     *     Esse método é utilizado para adaptar os dados vindos da camada de persistência
     *     (banco de dados) para o modelo de domínio usado na aplicação.
     * <p/>
     * @param livroEntityPage -> Entidade JPA do tipo Page<> representando os livros no banco.
     * @return -> retorna uma lista de livros
     */
    public List<Livro> toLivrosPageDomain(Page<LivroEntity> livroEntityPage) {
        return livroEntityPage
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
}