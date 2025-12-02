package com.projeto.IForum.dto;

import com.projeto.IForum.model.Aluno;

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
public class AlunoDTO {

    private Long id; 

    @NotBlank(message = "O Nome é obrigatório.")
    @Size(min = 3, max = 120, message = "O Nome deve ter entre 3 e 120 caracteres.")
    private String nome;

    @NotBlank(message = "O email é obrigatório.")
    @Email(message = "Formato de email inválido.")
    @Size(max = 180, message = "O email deve ter no máximo 180 caracteres.")
    private String email;

    @NotBlank(message = "A senha é obrigatória.")
    @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres.")
    private String senha; 

    @NotBlank(message = "A matrícula é obrigatória.")
    @Size(max = 120, message = "A matrícula deve ter no máximo 120 caracteres.")
    private String matricula;

    public static AlunoDTO fromEntity(Aluno aluno) {
        if (aluno == null) {
            return null;
        }
        return new AlunoDTO(
            aluno.getId(),
            aluno.getNome(),
            aluno.getEmail(),
            aluno.getSenha(),
            aluno.getMatricula()
        );
    }

    public static Aluno toEntity(AlunoDTO dto) {
        Aluno aluno = new Aluno();
        aluno.setId(dto.getId()); 
        aluno.setNome(dto.getNome());
        aluno.setEmail(dto.getEmail());
        aluno.setSenha(dto.getSenha());
        aluno.setMatricula(dto.getMatricula());
        return aluno;
    }
}
