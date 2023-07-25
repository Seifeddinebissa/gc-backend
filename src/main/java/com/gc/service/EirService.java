package com.gc.service;

import java.util.List;

import com.gc.entity.Eir;



public interface EirService {
	Eir addEIR(Eir eir);
    Eir updateEIR(Eir eir);
    void deleteEIR(Long id);
    List<Eir> getAllEIR();
    Eir getEIRById(Long id);
    Eir findEIRByDemande(Long idDemande);
    Integer getNbrEIRByAgentId(Long id);
    Integer getNbrEIRByArmateurId(Long id);
    Integer getNbrEirAllEir();
}
