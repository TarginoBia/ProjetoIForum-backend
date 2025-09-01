package com.projetodac.backend.CrudUser.dto;

public class AuthDTO{
    private String email;
    private String senha;

    public AuthDTO(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}