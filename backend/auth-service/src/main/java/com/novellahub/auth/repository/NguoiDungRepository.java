package com.novellahub.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.novellahub.auth.entity.NguoiDung;

public interface NguoiDungRepository extends JpaRepository<NguoiDung, Long> {

    Optional<NguoiDung> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
