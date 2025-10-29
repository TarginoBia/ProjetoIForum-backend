package com.projeto.IForum.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "alunos")
@PrimaryKeyJoinColumn(name = "user_id")
@Data
@NoArgsConstructor 
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true) 
public class Aluno extends Usuario {
    
    @Column(nullable = false, length = 120)
    private String matricula;
}
