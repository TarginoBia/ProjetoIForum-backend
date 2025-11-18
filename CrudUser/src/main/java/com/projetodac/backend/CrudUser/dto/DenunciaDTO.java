package com.projeto.IForum.dto;

import java.time.LocalDateTime;

import com.projeto.IForum.enums.Status;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor 
@AllArgsConstructor
public class DenunciaDTO {

    private Long id; 
    private LocalDateTime dataCriacao;
    private Status status; 
    
    private Long autorId; 
        
    @NotBlank(message = "O título da denúncia é obrigatório.")
    @Size(max = 100, message = "O título deve ter no máximo 100 caracteres.")
    private String titulo;

    @NotBlank(message = "O conteúdo da denúncia é obrigatório.")
    @Size(max = 5000, message = "O conteúdo não pode exceder 5000 caracteres.")
    private String conteudo;
    
}