package com.projetodac.backend.CrudUser.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcionarios")
public class Funcionario extends User {

    @Column(nullable = false, length = 120)
    private String cargo;
}