package com.projeto.IForum.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "coordenadores")
@PrimaryKeyJoinColumn(name = "user_id")
public class Coordenador extends Usuario {
    
    @Column(nullable = false, length = 120)
    private String departamento;

}
