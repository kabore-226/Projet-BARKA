package com.barka.barka_backend.dto;

import com.barka.barka_backend.model.Role;
import com.barka.barka_backend.model.UserStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private Long id;

    private String nom;

    private String email;

    private Role role;

    private UserStatus status;

    private Boolean accountNonLocked;

    private Boolean enabled;

    private LocalDateTime lastLogin;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}