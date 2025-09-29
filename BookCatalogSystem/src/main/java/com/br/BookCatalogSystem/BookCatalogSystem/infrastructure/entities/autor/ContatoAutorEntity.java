package com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.entities.autor;

import jakarta.persistence.*;

@Entity
@Table(name = "contato_autor")
public class ContatoAutorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 255)
    private String email;

    @Column(length = 9)
    private String telefone;

    public ContatoAutorEntity() {
    }

    public ContatoAutorEntity(Long id, String email, String telefone) {
        this.id = id;
        this.email = email;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }
}
