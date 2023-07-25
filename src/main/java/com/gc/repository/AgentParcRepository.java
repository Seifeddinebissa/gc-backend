package com.gc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gc.entity.AgentParc;
import com.gc.entity.Armateur;

public interface AgentParcRepository extends JpaRepository<AgentParc, Long> {
	AgentParc findByUserId(Long id);
	AgentParc findByEmail(String email);
}
