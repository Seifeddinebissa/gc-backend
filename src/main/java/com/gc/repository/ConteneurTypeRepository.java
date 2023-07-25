package com.gc.repository;

import com.gc.entity.ConteneurType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConteneurTypeRepository extends JpaRepository<ConteneurType, Long> {
}
