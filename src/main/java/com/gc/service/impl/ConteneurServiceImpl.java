package com.gc.service.impl;

import java.util.List;

import com.gc.entity.ConteneurNoInDemande;
import com.gc.rest.dto.LastDemandeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gc.entity.Conteneur;
import com.gc.repository.ConteneurRepository;
import com.gc.service.ConteneurService;

@Service
public class ConteneurServiceImpl implements ConteneurService{

	@Autowired
	ConteneurRepository conteneurRepository;
	@Override
	public Conteneur addConteneur(Conteneur c) {
			return conteneurRepository.save(c);
	}


	@Override
	public Conteneur updateConteneur(Conteneur c) {
		return conteneurRepository.save(c);
	}

	@Override
	public void deleteConteneurById(Long id) {
		conteneurRepository.deleteById(id);
		
	}

	@Override
	public Conteneur getConteneur(Long id) {
		return conteneurRepository.findById(id).get();
	}

	@Override
	public List<Conteneur> getAllConteneurs() {
		return conteneurRepository.findAll();
	}


	@Override
	public List<Conteneur> findByArmateurId(Long id) {
		return conteneurRepository.findByArmateurId(id);
	}


	@Override
	public List<Conteneur> findByTypeConteneur(Long id) {
		return conteneurRepository.findByConteneurTypeId(id);
	}


	@Override
	public List<Conteneur> getByArmateurAndStatus(Long id, String status) {
		return conteneurRepository.findByArmateurIdAndStatus(id, status);
	}

	@Override
	public List<ConteneurNoInDemande> findConteneurNotInDemande() {
		return conteneurRepository.findConteneursNotInDemande();
	}


	@Override
	public List<Conteneur> getByParcId(Long id) {
		return conteneurRepository.findByParcId(id);
	}

	@Override
	public Boolean conteneurExist(String marquage) {
		Conteneur ctn = conteneurRepository.findByMarquage(marquage.toUpperCase());
		if (ctn == null){
			return false;
		}else{
			return true;
		}
	}

}
