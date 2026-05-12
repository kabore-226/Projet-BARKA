
package com.barka.barka_backend.service;

import com.barka.barka_backend.dto.CreateVilleDto;
import com.barka.barka_backend.dto.UpdateVilleDto;
import com.barka.barka_backend.dto.VilleDto;
import com.barka.barka_backend.model.VilleModel;
import com.barka.barka_backend.repository.VilleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VilleService {

    private final VilleRepository villeRepository;

    // ✅ CREATE VILLE
    public VilleDto create(CreateVilleDto dto, Long createdBy) {

        if (villeRepository.existsByCodeVille(dto.getCodeVille())) {
            throw new RuntimeException("Ville code already exists");
        }

        VilleModel ville = VilleModel.builder()
                .codeVille(dto.getCodeVille())
                .nomVille(dto.getNomVille())
                .createdBy(createdBy)
                .deleted(false)
                .build();

        return mapToDto(villeRepository.save(ville));
    }

    // ✅ GET ALL VILLES
    public List<VilleDto> getAll() {
        return villeRepository.findAll()
                .stream()
                .filter(ville -> !Boolean.TRUE.equals(ville.getDeleted()))
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    // ✅ GET VILLE BY ID
    public VilleDto getById(Long id) {

        VilleModel ville = villeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ville not found"));

        return mapToDto(ville);
    }

    // ✅ GET VILLE BY CODE
    public VilleDto getByCode(String codeVille) {

        VilleModel ville = villeRepository.findByCodeVille(codeVille)
                .orElseThrow(() -> new RuntimeException("Ville not found"));

        return mapToDto(ville);
    }

    // ✅ UPDATE VILLE
    public VilleDto update(Long id, UpdateVilleDto dto) {

        VilleModel ville = villeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ville not found"));

        ville.setCodeVille(dto.getCodeVille());
        ville.setNomVille(dto.getNomVille());

        return mapToDto(villeRepository.save(ville));
    }

    // ✅ SOFT DELETE VILLE
    public void delete(Long id) {

        VilleModel ville = villeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ville not found"));

        ville.setDeleted(true);

        villeRepository.save(ville);
    }

    // ✅ DTO MAPPER
    private VilleDto mapToDto(VilleModel ville) {
        return VilleDto.builder()
                .idVille(ville.getIdVille())
                .codeVille(ville.getCodeVille())
                .nomVille(ville.getNomVille())
                .createdBy(ville.getCreatedBy())
                .createdAt(ville.getCreatedAt())
                .updatedAt(ville.getUpdatedAt())
                .build();
    }
}
