package com.demoapplication.springbootrestfulwebservices.services;

import com.demoapplication.springbootrestfulwebservices.dto.UserDto;
import com.demoapplication.springbootrestfulwebservices.entities.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto getUserById(Long id);
    List<UserDto> getAllUsers();
    UserDto updateUserById(Long id, UserDto userDto);
    String deleteUserById(Long id);
}
