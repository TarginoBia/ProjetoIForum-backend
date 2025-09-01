
package com.projetodac.backend.CrudUser.interfaces;

import java.util.List;

import org.mapstruct.Mapper;

import com.projetodac.backend.CrudUser.dto.FuncionarioDTO;
import com.projetodac.backend.CrudUser.model.Funcionario;

@Mapper(componentModel = "spring")
public interface FuncionarioMapper {

    FuncionarioDTO toFuncionarioDTO(Funcionario funcionario);

    Funcionario toFuncionario(FuncionarioDTO funcionarioDTO);

    List<FuncionarioDTO> toFuncionarioDTOList(List<Funcionario> funcionarios);
}