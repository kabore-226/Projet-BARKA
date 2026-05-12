package com.barka.barka_backend.dto;

import com.barka.barka_backend.model.Role;
import com.barka.barka_backend.model.UserStatus;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateUserDto {

    private String nom;

    private String email;

    private Role role;

    private UserStatus status;

    private Boolean enabled;

    private Boolean accountNonLocked;
}