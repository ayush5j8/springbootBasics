package com.demoapplication.springbootrestfulwebservices.mapper;

import com.demoapplication.springbootrestfulwebservices.dto.UserDto;
import com.demoapplication.springbootrestfulwebservices.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {

    // in case of a mismatched field we can use @mapping(source="mail",target="mail") or vice versa
    // depending on source to target conversion

    AutoUserMapper MAPPER= Mappers.getMapper(AutoUserMapper.class);
    UserDto mapToUserDto(User user);
    User mapToUser(UserDto userDto);
}
