package com.demoapplication.springbootrestfulwebservices.mapper;

import com.demoapplication.springbootrestfulwebservices.dto.UserDto;
import com.demoapplication.springbootrestfulwebservices.entities.User;

public class UserMapper {
    public static UserDto mapToDto(User user){
        return new UserDto(user.getId(),user.getFirstName(),user.getLastName(),user.getEmail());
    }
    public static User mapToJpa(UserDto userDto){
        return new User(userDto.getId(),userDto.getFirstName(),userDto.getLastName(),userDto.getEmail());
    }
}
