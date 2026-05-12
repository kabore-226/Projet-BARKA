package com.barka.barka_backend.service;

import com.barka.barka_backend.dto.CreateUserDto;
import com.barka.barka_backend.dto.UpdateUserDto;
import com.barka.barka_backend.dto.UserDto;
import com.barka.barka_backend.model.Role;
import com.barka.barka_backend.model.UserStatus;
import com.barka.barka_backend.model.UsersModel;
import com.barka.barka_backend.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    // ✅ CREATE USER
    public UserDto create(CreateUserDto dto) {

        if (usersRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        UsersModel user = UsersModel.builder()
                .nom(dto.getNom())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .role(dto.getRole())
                .status(UserStatus.ACTIVE)
                .accountNonLocked(true)
                .enabled(true)
                .deleted(false)
                .build();

        return mapToDto(usersRepository.save(user));
    }

    // ✅ GET ALL USERS
    public List<UserDto> getAll() {
        return usersRepository.findAll()
                .stream()
                .filter(user -> !Boolean.TRUE.equals(user.getDeleted()))
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    // ✅ GET USER BY ID
    public UserDto getById(Long id) {
        UsersModel user = usersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return mapToDto(user);
    }

    // ✅ GET USER BY EMAIL
    public UserDto getByEmail(String email) {
        UsersModel user = usersRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return mapToDto(user);
    }

    // ✅ UPDATE USER
    public UserDto update(Long id, UpdateUserDto dto) {

        UsersModel user = usersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setNom(dto.getNom());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole());
        user.setStatus(dto.getStatus());
        user.setEnabled(dto.getEnabled());
        user.setAccountNonLocked(dto.getAccountNonLocked());

        return mapToDto(usersRepository.save(user));
    }

    // ✅ SUSPEND USER
    public UserDto suspend(Long id) {

        UsersModel user = usersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setStatus(UserStatus.SUSPENDED);
        user.setAccountNonLocked(false);

        return mapToDto(usersRepository.save(user));
    }

    // ✅ ACTIVATE USER
    public UserDto activate(Long id) {

        UsersModel user = usersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setStatus(UserStatus.ACTIVE);
        user.setAccountNonLocked(true);
        user.setEnabled(true);

        return mapToDto(usersRepository.save(user));
    }

    // ✅ DISABLE USER
    public UserDto disable(Long id) {

        UsersModel user = usersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setEnabled(false);
        user.setStatus(UserStatus.DISABLED);

        return mapToDto(usersRepository.save(user));
    }

    // ✅ UPDATE PASSWORD
    public void updatePassword(Long id, String password) {

        UsersModel user = usersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setPassword(passwordEncoder.encode(password));

        usersRepository.save(user);
    }

    // ✅ UPDATE LAST LOGIN
    public void updateLastLogin(Long id) {

        UsersModel user = usersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setLastLogin(LocalDateTime.now());

        usersRepository.save(user);
    }

    // ✅ SOFT DELETE USER
    public void delete(Long id) {

        UsersModel user = usersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setDeleted(true);

        usersRepository.save(user);
    }

    // ✅ DTO MAPPER
    private UserDto mapToDto(UsersModel user) {
        return UserDto.builder()
                .id(user.getId())
                .nom(user.getNom())
                .email(user.getEmail())
                .role(user.getRole())
                .status(user.getStatus())
                .accountNonLocked(user.getAccountNonLocked())
                .enabled(user.getEnabled())
                .lastLogin(user.getLastLogin())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }
}
