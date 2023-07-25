package com.gc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gc.entity.Dommage;
import java.lang.String;

@Repository
public interface DommageRepository extends JpaRepository<Dommage, Long> {
	Dommage findByIntitule(String intitule);
}
