package com.gc.service;

import java.util.Date;
import java.util.List;


import com.gc.entity.Demande;
import com.gc.rest.dto.LastDemandeDto;


public interface DemandeService {
	Demande addDemande(Demande demande);
    Demande updateDemande(Demande demande);
    void deleteDemande(Long id);
    List<Demande> getAllDemande();
    Demande getDemandeById(Long id);
    List<Demande> findByArmateurId(Long id);
    List<Demande> findByAgentId(Long id);
    List<Demande> findByDateCreation(Date date);
    List<LastDemandeDto> findLastDemandeTraite();
    List<Demande> findByUpdateTimeContains(String date);
}
