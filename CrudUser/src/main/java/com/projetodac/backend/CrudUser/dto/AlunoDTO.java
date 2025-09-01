package com.projetodac.backend.CrudUser.dto;

public class AlunoDTO{
    private String matricula;
    private String nome;
    private String email;

    public AlunoDTO(String matricula, String nome, String email) {
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
