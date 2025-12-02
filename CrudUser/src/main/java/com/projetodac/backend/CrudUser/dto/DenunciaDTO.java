package com.projeto.IForum.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projeto.IForum.enums.Status;
import com.projeto.IForum.model.Denuncia;

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
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") 
    private LocalDateTime dataRegistro;
    private Status status; 
    
    private Long autorId; 
        
    @NotBlank(message = "O título da denúncia é obrigatório.")
    @Size(max = 100, message = "O título deve ter no máximo 100 caracteres.")
    private String titulo;

    @NotBlank(message = "O conteúdo da denúncia é obrigatório.")
    @Size(max = 5000, message = "O conteúdo não pode exceder 5000 caracteres.")
    private String descricao;
    
    public static DenunciaDTO fromEntity(Denuncia denuncia) {
        if (denuncia == null) {
            return null;
        }
        return new DenunciaDTO(
            denuncia.getId(),
            denuncia.getDataRegistro(),
            denuncia.getStatus(),
            denuncia.getAutorID().getId(),
            denuncia.getTitulo(),
            denuncia.getDescricao()
        );
    }

    public static Denuncia toEntity(DenunciaDTO dto) {
        Denuncia denuncia = new Denuncia();
        denuncia.setId(dto.getId()); 
        denuncia.setDescricao(dto.getDescricao());
        denuncia.setDataRegistro(dto.getDataRegistro());
        denuncia.setStatus(dto.getStatus());
        denuncia.setTitulo(dto.getTitulo());
        return denuncia;
    }
}
