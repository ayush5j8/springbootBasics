package com.demoapplication.springbootrestfulwebservices.controllers;

import com.demoapplication.springbootrestfulwebservices.dto.UserDto;
import com.demoapplication.springbootrestfulwebservices.entities.User;
import com.demoapplication.springbootrestfulwebservices.exceptions.ErrorDetails;
import com.demoapplication.springbootrestfulwebservices.exceptions.ResourceNotFoundException;
import com.demoapplication.springbootrestfulwebservices.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Tag(
        name="CRUD user resource",
        description = "This controller queries all crud wrt USER"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private UserService userService;

    @Operation(
            summary = "Create a user",
            description = "creates a user and adds it to database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 : CREATED"
    )
    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid  @RequestBody UserDto user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateById(@PathVariable Long id,@Valid @RequestBody UserDto updatedFields){
        return ResponseEntity.ok(userService.updateUserById(id,updatedFields));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        return ResponseEntity.ok(userService.deleteUserById(id));
    }
}
