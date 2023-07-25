package com.gc.repository;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gc.rest.dto.LastDemandeDto;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gc.entity.Demande;
import org.springframework.data.jpa.repository.Query;

public interface DemandeRepository extends JpaRepository<Demande, Long> {
List<Demande> findByArmId(Long id);
List<Demande> findByAgentId(Long id);
List<Demande> findByDateCreation(Date date);

@Query(nativeQuery = true, name = "Demande.findLastDemandeTraite")
    List<LastDemandeDto> findLastDemandeTraite();
List<Demande> findByUpdateTimeContainingAndAgentNotNull(String date);
}
