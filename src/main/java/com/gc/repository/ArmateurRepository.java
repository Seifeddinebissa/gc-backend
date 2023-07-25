package com.gc.repository;

import com.gc.entity.Armateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArmateurRepository extends JpaRepository<Armateur, Long> {
    Armateur findByUserId(Long id);
    Armateur findByEmail(String email);
}
