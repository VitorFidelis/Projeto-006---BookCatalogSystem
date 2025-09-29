package com.br.BookCatalogSystem.BookCatalogSystem.domain.model.editora;

import java.util.UUID;

public class EditoraModel {
    private UUID id;
    private String name;
    private String cnpj;
    private String site;
    private Long id_endereco;
    private Long id_contato;

    public EditoraModel() {

    }

    public EditoraModel(UUID id, String name, String cnpj, String site, Long id_endereco, Long id_contato) {
        this.id = id;
        this.name = name;
        this.cnpj = cnpj;
        this.site = site;
        this.id_endereco = id_endereco;
        this.id_contato = id_contato;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Long getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(Long id_endereco) {
        this.id_endereco = id_endereco;
    }

    public Long getId_contato() {
        return id_contato;
    }

    public void setId_contato(Long id_contato) {
        this.id_contato = id_contato;
    }
}
