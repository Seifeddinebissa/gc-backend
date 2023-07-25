package com.gc.service.impl;

import java.util.Date;
import java.util.List;

import com.gc.entity.Conteneur;
import com.gc.rest.dto.LastDemandeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gc.entity.Demande;
import com.gc.repository.DemandeRepository;
import com.gc.service.DemandeService;
@Service
public class DemandeServiceImp implements DemandeService{
	@Autowired
    DemandeRepository demandeRepository;
	@Override
	public Demande addDemande(Demande demande) {
		demande.setDateCreation(new Date());
		return demandeRepository.save(demande);
	}

	@Override
	public Demande updateDemande(Demande demande) {
		return demandeRepository.save(demande);
	}

	@Override
	public void deleteDemande(Long id) {
		 demandeRepository.deleteById(id);
		
	}

	@Override
	public List<Demande> getAllDemande() {
		return demandeRepository.findAll();
	}

	@Override
	public Demande getDemandeById(Long id) {
		return demandeRepository.findById(id).get();
	}

	@Override
	public List<Demande> findByArmateurId(Long id) {
		return demandeRepository.findByArmId(id);
	}

	@Override
	public List<Demande> findByAgentId(Long id) {
		return demandeRepository.findByAgentId(id);
	}

	@Override
	public List<Demande> findByDateCreation( Date date) {
		return demandeRepository.findByDateCreation(date);
	}

	@Override
	public List<LastDemandeDto> findLastDemandeTraite() {
		return demandeRepository.findLastDemandeTraite();
	}

	@Override
	public List<Demande> findByUpdateTimeContains(String date) {
		return demandeRepository.findByUpdateTimeContainingAndAgentNotNull(date);
	}

}
