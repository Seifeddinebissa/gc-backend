package com.gc.service;

import java.util.List;

import com.gc.entity.Conteneur;
import com.gc.entity.ConteneurNoInDemande;
import com.gc.rest.dto.LastDemandeDto;


public interface ConteneurService {
	Conteneur addConteneur(Conteneur c);

	Conteneur updateConteneur(Conteneur c);

	void deleteConteneurById(Long id);

	Conteneur getConteneur(Long id);

	List<Conteneur> getAllConteneurs();
	
	List<Conteneur> findByArmateurId(Long id);
	
	List<Conteneur> findByTypeConteneur(Long id);
	
	List<Conteneur> getByArmateurAndStatus(Long id, String status);
	List<ConteneurNoInDemande> findConteneurNotInDemande();
	List<Conteneur> getByParcId(Long id);
	Boolean conteneurExist(String marquage);

}
