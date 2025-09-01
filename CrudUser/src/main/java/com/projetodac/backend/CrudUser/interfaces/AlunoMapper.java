package com.projetodac.backend.CrudUser.interfaces;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.projetodac.backend.CrudUser.dto.AlunoDTO;
import com.projetodac.backend.CrudUser.model.Aluno;

@Mapper(componentModel = "spring")
public interface AlunoMapper {

    AlunoDTO toAlunoDTO(Aluno aluno);

    @Mapping(target = "id", ignore = true)
    Aluno toAluno(AlunoDTO alunoDTO);

    List<AlunoDTO> toAlunoDTOList(List<Aluno> alunos);
}
