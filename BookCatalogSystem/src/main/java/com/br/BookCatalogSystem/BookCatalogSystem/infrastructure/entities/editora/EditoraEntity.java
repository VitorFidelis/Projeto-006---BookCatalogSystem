package com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.entities.editora;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "editora")
public class EditoraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length = 255, nullable = false)
    private String name;

    @Column(length = 14, nullable = false, unique = true)
    private String cnpj;

    @Column(nullable = false)
    private String site;

    @Column(nullable = false)
    private Long id_endereco;

    @Column(nullable = false)
    private Long id_contato;

    public EditoraEntity() {
    }

    public EditoraEntity(UUID id, String name, String cnpj, String site, Long id_endereco, Long id_contato) {
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

    public String getName() {
        return name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getSite() {
        return site;
    }

    public Long getId_endereco() {
        return id_endereco;
    }

    public Long getId_contato() {
        return id_contato;
    }
}
