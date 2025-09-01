
package com.projetodac.backend.CrudUser.interfaces;

import java.util.List;

import org.mapstruct.Mapper;

import com.projetodac.backend.CrudUser.dto.DenunciaDTO;
import com.projetodac.backend.CrudUser.model.Denuncia;

@Mapper(componentModel = "spring")
public interface DenunciaMapper {

    DenunciaDTO toDenunciaDto(Denuncia denuncia);

    Denuncia toDenuncia(DenunciaDTO denunciaDTO);

    List<DenunciaDTO> toDenunciaDtoList(List<Denuncia> denuncias);
}