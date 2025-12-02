package com.projeto.IForum.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@PrimaryKeyJoinColumn(name = "user_id")
@Entity
@Data
@NoArgsConstructor 
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Coordenador extends Usuario {
    
    @Column(nullable = false, length = 120)
    private String departamento;

}
