package com.barka.barka_backend.controller;

import com.barka.barka_backend.dto.CreateUserDto;
import com.barka.barka_backend.dto.UpdateUserDto;
import com.barka.barka_backend.dto.UserDto;
import com.barka.barka_backend.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UsersController {

    private final UsersService usersService;

    // ✅ CREATE USER
    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody CreateUserDto dto) {
        return new ResponseEntity<>(usersService.create(dto), HttpStatus.CREATED);
    }
    // ✅ GET ALL USERS
    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(usersService.getAll());
    }

    // ✅ GET USER BY ID
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(usersService.getById(id));
    }

    // ✅ GET USER BY EMAIL
    @GetMapping("/email/{email}")
    public ResponseEntity<UserDto> getByEmail(@PathVariable String email) {
        return ResponseEntity.ok(usersService.getByEmail(email));
    }
    // ✅ UPDATE USER
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(
            @PathVariable Long id,
            @RequestBody UpdateUserDto dto
    ) {
        return ResponseEntity.ok(usersService.update(id, dto));
    }

    // ✅ SUSPEND USER
    @PutMapping("/{id}/suspend")
    public ResponseEntity<UserDto> suspend(@PathVariable Long id) {
        return ResponseEntity.ok(usersService.suspend(id));
    }
    // ✅ ACTIVATE USER
    @PutMapping("/{id}/activate")
    public ResponseEntity<UserDto> activate(@PathVariable Long id) {
        return ResponseEntity.ok(usersService.activate(id));
    }

    // ✅ DISABLE USER
    @PutMapping("/{id}/disable")
    public ResponseEntity<UserDto> disable(@PathVariable Long id) {
        return ResponseEntity.ok(usersService.disable(id));
    }
    // ✅ UPDATE PASSWORD
    @PutMapping("/{id}/password")
    public ResponseEntity<String> updatePassword(
            @PathVariable Long id,
            @RequestParam String password
    ) {
        usersService.updatePassword(id, password);
        return ResponseEntity.ok("Password updated successfully");
    }

    // ✅ DELETE USER
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        usersService.delete(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}