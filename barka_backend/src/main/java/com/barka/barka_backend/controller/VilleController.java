package com.barka.barka_backend.controller;

import com.barka.barka_backend.dto.CreateVilleDto;
import com.barka.barka_backend.dto.UpdateVilleDto;
import com.barka.barka_backend.dto.VilleDto;
import com.barka.barka_backend.service.VilleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/villes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class VilleController {
    private final VilleService villeService;

    // ✅ CREATE VILLE
    @PostMapping
    public ResponseEntity<VilleDto> create(
            @RequestBody CreateVilleDto dto,
            @RequestParam Long createdBy
    ) {
        return new ResponseEntity<>(villeService.create(dto, createdBy), HttpStatus.CREATED);
    }

    // ✅ GET ALL VILLES
    @GetMapping
    public ResponseEntity<List<VilleDto>> getAll() {
        return ResponseEntity.ok(villeService.getAll());
    }
    // ✅ GET VILLE BY ID
    @GetMapping("/{id}")
    public ResponseEntity<VilleDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(villeService.getById(id));
    }

    // ✅ GET VILLE BY CODE
    @GetMapping("/code/{codeVille}")
    public ResponseEntity<VilleDto> getByCode(@PathVariable String codeVille) {
        return ResponseEntity.ok(villeService.getByCode(codeVille));
    }
    // ✅ UPDATE VILLE
    @PutMapping("/{id}")
    public ResponseEntity<VilleDto> update(
            @PathVariable Long id,
            @RequestBody UpdateVilleDto dto
    ) {
        return ResponseEntity.ok(villeService.update(id, dto));
    }

    // ✅ DELETE VILLE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        villeService.delete(id);
        return ResponseEntity.ok("Ville deleted successfully");
    }
}