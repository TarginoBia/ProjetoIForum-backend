package com.projeto.IForum.model;

import java.time.LocalDateTime;

import com.projeto.IForum.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Denuncia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(nullable = false, length = 500)
    private String descricao;

    @Column(nullable = false)
    private Status status; 

    @Column(nullable = false)
    private LocalDateTime dataRegistro;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false) 
    private Usuario usuario; 

}
