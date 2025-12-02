package com.projeto.IForum.dto;

import com.projeto.IForum.model.Coordenador;

import jakarta.validation.constraints.Email;
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
public class CoordenadorDTO {

    private Long id; 
    
    @NotBlank(message = "O nome é obrigatório.")
    @Size(min = 3, max = 120, message = "O nome deve ter entre 3 e 120 caracteres.")
    private String nome;

    @NotBlank(message = "O email é obrigatório.")
    @Email(message = "Formato de email inválido.")
    @Size(max = 180, message = "O email deve ter no máximo 180 caracteres.")
    private String email;

    @NotBlank(message = "A senha é obrigatória.")
    @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres.")
    private String senha; 
    
    @NotBlank(message = "O departamento é obrigatório.")
    @Size(max = 120, message = "O nome do departamento deve ter no máximo 120 caracteres.")
    private String departamento;
    
    public static CoordenadorDTO fromEntity(Coordenador coordenador) {
        if (coordenador == null) {
            return null;
        }
        return new CoordenadorDTO(
            coordenador.getId(),
            coordenador.getNome(),
            coordenador.getEmail(),
            coordenador.getSenha(),
            coordenador.getDepartamento()
        );
    }

    public static Coordenador toEntity(CoordenadorDTO dto) {
        Coordenador coordenador = new Coordenador();
        coordenador.setId(dto.getId()); 
        coordenador.setNome(dto.getNome());
        coordenador.setEmail(dto.getEmail());
        coordenador.setSenha(dto.getSenha());
        coordenador.setDepartamento(dto.getDepartamento());
        return coordenador;
    }
}
