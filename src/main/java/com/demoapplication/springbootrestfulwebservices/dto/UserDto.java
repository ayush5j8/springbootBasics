package com.demoapplication.springbootrestfulwebservices.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "User Dto"
)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long id;
    @NotEmpty
    @Schema(description = "User firstname")
    private String firstName;
    @NotEmpty
    @Schema(description = "User lastName")
    private String lastName;
    @Schema(description = "User email")
    @NotEmpty
    @Email
    private String email;
}
