package com.br.BookCatalogSystem.BookCatalogSystem.domain.model.autor;

import java.util.UUID;

public class AutorModel {
    private UUID id;
    private Boolean ativo = true;
    private String nome;
    private String sobrenome;
    private String cpf;
    private ContatoAutorModel contatoAutorModel;
    private EnderecoAutorModel enderecoAutorModel;

    public AutorModel() {

    }

    public AutorModel(UUID id, Boolean ativo, String nome, String sobrenome, String cpf, ContatoAutorModel contatoAutorModel, EnderecoAutorModel enderecoAutorModel) {
        this.id = id;
        this.ativo = true;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.contatoAutorModel = contatoAutorModel;
        this.enderecoAutorModel = enderecoAutorModel;
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

    public ContatoAutorModel getContatoAutorModel() {
        return contatoAutorModel;
    }

    public void setContatoAutorModel(ContatoAutorModel contatoAutorModel) {
        this.contatoAutorModel = contatoAutorModel;
    }

    public EnderecoAutorModel getEnderecoAutorModel() {
        return enderecoAutorModel;
    }

    public void setEnderecoAutorModel(EnderecoAutorModel enderecoAutorModel) {
        this.enderecoAutorModel = enderecoAutorModel;
    }
}