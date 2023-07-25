package com.gc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gc.entity.Eir;



public interface EIRRepository extends JpaRepository<Eir, Long> {
Eir findByDemandeId(Long id);
List<Eir> findByDemandeAgentId(Long id);
List<Eir> findByDemandeArmId(Long id);
}
