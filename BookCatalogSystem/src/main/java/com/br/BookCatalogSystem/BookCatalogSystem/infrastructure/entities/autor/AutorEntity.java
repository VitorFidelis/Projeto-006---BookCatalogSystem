package com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.entities.autor;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "autor")
public class AutorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private Boolean ativo = true;

    @Column(length = 100)
    private String nome;

    @Column(length = 100)
    private String sobrenome;

    @Column(length = 20)
    private String cpf;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contato_id", referencedColumnName = "id", nullable = true)
    private ContatoAutorEntity contatoAutorEntity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id", nullable = true)
    private EnderecoAutorEntity enderecoAutorEntity;

    public AutorEntity() {

    }

    public AutorEntity(UUID id, Boolean ativo, String nome, String sobrenome, String cpf, ContatoAutorEntity contatoAutorEntity, EnderecoAutorEntity enderecoAutorEntity) {
        this.id = id;
        this.ativo = true;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.contatoAutorEntity = contatoAutorEntity;
        this.enderecoAutorEntity = enderecoAutorEntity;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ContatoAutorEntity getContatoAutorEntity() {
        return contatoAutorEntity;
    }

    public void setContatoAutorEntity(ContatoAutorEntity contatoAutorEntity) {
        this.contatoAutorEntity = contatoAutorEntity;
    }

    public EnderecoAutorEntity getEnderecoAutorEntity() {
        return enderecoAutorEntity;
    }

    public void setEnderecoAutorEntity(EnderecoAutorEntity enderecoAutorEntity) {
        this.enderecoAutorEntity = enderecoAutorEntity;
    }
}
