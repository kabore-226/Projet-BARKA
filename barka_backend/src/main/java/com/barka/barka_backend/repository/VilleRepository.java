package com.barka.barka_backend.repository;

import com.barka.barka_backend.model.VilleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VilleRepository extends JpaRepository<VilleModel, Long> {

    Optional<VilleModel> findByCodeVille(String codeVille);

    Boolean existsByCodeVille(String codeVille);
}