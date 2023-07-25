package com.gc.repository;

import java.util.List;

import com.gc.entity.ConteneurNoInDemande;
import com.gc.rest.dto.LastDemandeDto;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gc.entity.Conteneur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.gc.entity.Parc;


@Repository
public interface ConteneurRepository extends JpaRepository<Conteneur, Long> {
List<Conteneur> findByArmateurId(Long id);
List<Conteneur> findByConteneurTypeId(Long id);
List<Conteneur> findByArmateurIdAndStatus(Long id, String status );
    @Query(nativeQuery = true, name = "Demande.findConteneursNotInDemande")
    List<ConteneurNoInDemande> findConteneursNotInDemande();
 List<Conteneur> findByParcId(Long id);
 Conteneur findByMarquage(String marquage);

}
