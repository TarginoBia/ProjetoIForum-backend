
package com.projetodac.backend.CrudUser.interfaces;

import java.util.List;

import org.mapstruct.Mapper;

import com.projetodac.backend.CrudUser.dto.CoordenadorDTO;
import com.projetodac.backend.CrudUser.model.Coordenador;

@Mapper(componentModel = "spring")
public interface CoordenadorMapper {

    CoordenadorDTO toCoordenadorDTO(Coordenador coordenador);

    Coordenador toCoordenador(CoordenadorDTO coordenadorDTO);

    List<CoordenadorDTO> toCoordenadorDTOList(List<Coordenador> coordenadores);
}