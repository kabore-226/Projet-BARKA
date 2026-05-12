package com.barka.barka_backend.dto;

import com.barka.barka_backend.model.Role;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserDto {

    private String nom;

    private String email;

    private String password;

    private Role role;
}