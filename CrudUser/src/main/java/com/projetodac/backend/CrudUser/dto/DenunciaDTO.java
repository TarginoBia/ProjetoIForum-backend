package com.projetodac.backend.CrudUser.dto;

import com.projetodac.backend.CrudUser.enums.Status;

public class DenunciaDTO{
    private Long id;

    private String titulo;

    private String descricao;

    private Status status;

    private String nomeUsuario;

    private String emailUsuario;

    public DenunciaDTO(Long id, String titulo, String descricao, Status status, String nomeUsuario, String emailUsuario) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Status getStatus() {
        return status;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }
}