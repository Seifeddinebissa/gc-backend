package com.gc.repository;

import com.gc.entity.Parc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcRepository extends JpaRepository<Parc, Long> {
}
