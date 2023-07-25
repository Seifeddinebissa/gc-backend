package com.gc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gc.entity.Dommage;
import com.gc.repository.DommageRepository;
import com.gc.service.DommageService;

@Service
public class DommageServiceImpl implements DommageService {

	@Autowired
	DommageRepository dommageRepository;
	
	@Override
	public Dommage getDommageById(Long id) {
		return dommageRepository.findById(id).get();
	}

	@Override
	public Dommage addDommage(Dommage dommage) {
		return dommageRepository.save(dommage);
	}

	@Override
	public Dommage updateDommage(Dommage dommage, Long id) {
		dommage.setId(id);
		return dommageRepository.save(dommage);
	}

	@Override
	public List<Dommage> getAll() {
		return (List<Dommage>) dommageRepository.findAll();
	}

	@Override
	public void deletDommage(Long id) {
		dommageRepository.deleteById(id);
		
	}

	@Override
	public Dommage getDommageByIntitule(String intitule) {
		return dommageRepository.findByIntitule(intitule);
	}

}
