package com.projeto.IForum.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Funcionario extends Usuario {

    @Column(nullable = false, length = 120)
    private String cargo;
}
