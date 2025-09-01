package com.projetodac.backend.CrudUser.interfaces;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.projetodac.backend.CrudUser.dto.UserDTO;
import com.projetodac.backend.CrudUser.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toUserDto(User user);

    @Mapping(target = "id", ignore = true)
    User toUser(UserDTO userDto);

    List<UserDTO> toUserDtoList(List<User> users);
}