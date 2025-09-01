package com.projetodac.backend.CrudUser.interfaces;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.projetodac.backend.CrudUser.dto.AuthDTO;
import com.projetodac.backend.CrudUser.model.User;

@Mapper(componentModel = "spring")
public interface AuthMapper {

    @Mapping(target = "email", ignore = true)
    @Mapping(target = "senha", ignore = true)
    AuthDTO toAuthDto(User user);

    User toUser(AuthDTO authDTO);
}