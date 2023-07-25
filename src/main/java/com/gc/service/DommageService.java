package com.gc.service;

import java.util.List;

import com.gc.entity.Dommage;


public interface DommageService {
	
	Dommage getDommageById(Long id);

	Dommage addDommage(Dommage dommage);

	Dommage updateDommage(Dommage dommage, Long id);

	List<Dommage> getAll();

	void deletDommage(Long id);
	
	Dommage getDommageByIntitule(String intitule);
}
