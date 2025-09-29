package com.br.BookCatalogSystem.BookCatalogSystem.domain.model.autor;

public class ContatoAutorModel {
    private Long id;
    private String email;
    private String telefone;

    public ContatoAutorModel() {

    }

    public ContatoAutorModel(String email, String telefone) {
        this.email = email;
        this.telefone = telefone;
    }

    public ContatoAutorModel(Long id, String email, String telefone) {
        this.id = id;
        this.email = email;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
