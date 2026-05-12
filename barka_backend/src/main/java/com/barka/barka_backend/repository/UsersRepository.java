package com.barka.barka_backend.repository;

import com.barka.barka_backend.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<UsersModel, Long> {

    Optional<UsersModel> findByEmail(String email);

    Boolean existsByEmail(String email);
}