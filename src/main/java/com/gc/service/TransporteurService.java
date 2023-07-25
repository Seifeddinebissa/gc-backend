package com.gc.service;

import com.gc.entity.Transporteur;

import java.util.List;

public interface TransporteurService {

	Transporteur addTransporteur(Transporteur transporteur);
    Transporteur updateTransporteur(Transporteur transporteur);
    void deleteTransporteur(Long id);
    List<Transporteur> getAllTransporteur();
    Transporteur getTransporteurById(Long id);

}
