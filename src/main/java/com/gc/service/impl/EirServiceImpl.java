package com.gc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gc.entity.Eir;
import com.gc.repository.EIRRepository;
import com.gc.service.EirService;
@Service
public class EirServiceImpl implements EirService{

	@Autowired
    EIRRepository eirRepository;
	
	@Override
	public Eir addEIR(Eir eir) {
		return eirRepository.save(eir);
	}

	@Override
	public Eir updateEIR(Eir eir) {
		return eirRepository.save(eir);
	}

	@Override
	public void deleteEIR(Long id) {
		eirRepository.deleteById(id);
	}

	@Override
	public List<Eir> getAllEIR() {
		return eirRepository.findAll();
	}

	@Override
	public Eir getEIRById(Long id) {
		return eirRepository.findById(id).get();
	}

	@Override
	public Eir findEIRByDemande(Long idDemande) {
		return eirRepository.findByDemandeId(idDemande);
	}

	@Override
	public Integer getNbrEIRByAgentId(Long id) {
		return eirRepository.findByDemandeAgentId(id).size();
	}

	@Override
	public Integer getNbrEIRByArmateurId(Long id) {
		return eirRepository.findByDemandeArmId(id).size();
	}

	@Override
	public Integer getNbrEirAllEir() {
		return eirRepository.findAll().size();
	}

}
