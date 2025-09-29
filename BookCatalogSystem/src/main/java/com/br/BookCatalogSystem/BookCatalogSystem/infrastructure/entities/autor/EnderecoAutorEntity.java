package com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.entities.autor;

import jakarta.persistence.*;

@Entity
@Table(name = "endereco_autor")
public class EnderecoAutorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100, nullable = false)
    private String rua;

    @Column(nullable = false)
    private int numero;

    @Column(length = 100, nullable = false)
    private String bairro;

    @Column(length = 100, nullable = false)
    private String cidade;

    @Column(length = 100, nullable = false)
    private String estado;

    @Column(length = 8, nullable = false)
    private String cep;

    public EnderecoAutorEntity() {

    }

    public EnderecoAutorEntity(Long id, String rua, int numero, String bairro, String cidade, String estado, String cep) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public String getRua() {
        return rua;
    }

    public int getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }
}
