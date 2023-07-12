package com.demoapplication.springbootrestfulwebservices.services;

import com.demoapplication.springbootrestfulwebservices.dto.UserDto;
import com.demoapplication.springbootrestfulwebservices.entities.User;
import com.demoapplication.springbootrestfulwebservices.exceptions.EmailAlreadyExistsException;
import com.demoapplication.springbootrestfulwebservices.exceptions.ResourceNotFoundException;
import com.demoapplication.springbootrestfulwebservices.mapper.AutoUserMapper;
import com.demoapplication.springbootrestfulwebservices.mapper.UserMapper;
import com.demoapplication.springbootrestfulwebservices.repositories.UserRepository;
import jakarta.validation.*;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    //private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto user) {
        // dto TO  jpa
        //User newUser= UserMapper.mapToJpa(user);
        //User newUser= modelMapper.map(user,User.class);
        Optional<User> optionalUser=userRepository.findByEmail(user.getEmail());
        if(optionalUser.isPresent()){
            throw new EmailAlreadyExistsException("Email Aready Exists");
        }
        User newUser= AutoUserMapper.MAPPER.mapToUser(user);
        User savedUser=userRepository.save(newUser);
        //return UserMapper.mapToDto(savedUser);
        //return modelMapper.map(savedUser,UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long id) {
        //Optional<User> optionalUser=userRepository.findById(id);
        User user=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("user","id",String.valueOf(id)));
        //return UserMapper.mapToDto(optionalUser.get());
        //return modelMapper.map(optionalUser.get(), UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        //List<UserDto> usersDto=userRepository.findAll().stream().map(UserMapper::mapToDto).collect(Collectors.toList());
        //List<UserDto> usersDto=userRepository.findAll().stream().map((user)-> modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
        List<UserDto> usersDto=userRepository.findAll().stream().map((user)-> AutoUserMapper.MAPPER.mapToUserDto(user)).collect(Collectors.toList());
        return usersDto;
    }

    @Override
    public UserDto updateUserById(Long id, UserDto userDto) {
        User updatedUser=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("user","id",String.valueOf(id)));

        //return UserMapper.mapToDto(userRepository.save(updatedUser));
       // return modelMapper.map(userRepository.save(updatedUser), UserDto.class);
        updatedUser.setFirstName(userDto.getFirstName());
        updatedUser.setLastName(userDto.getLastName());
        updatedUser.setEmail(userDto.getEmail());
        return AutoUserMapper.MAPPER.mapToUserDto(userRepository.save(updatedUser));
    }

    @Override
    public String deleteUserById(Long id) {
        User deleteUser=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("user","id",String.valueOf(id)));
        userRepository.deleteById(id);
        return "User deleted with Id: "+id;
    }
}
