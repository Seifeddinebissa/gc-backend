package com.gc.service.impl;

import com.gc.entity.Transporteur;
import com.gc.repository.TransporteurRepository;
import com.gc.service.TransporteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransporteurServiceImpl implements TransporteurService {

    @Autowired
    TransporteurRepository transporteurRepository;
    @Override
    public Transporteur addTransporteur(Transporteur transporteur) {
    	transporteur.setDateCreation(new Date());
        return transporteurRepository.save(transporteur);
    }

    @Override
    public Transporteur updateTransporteur(Transporteur transporteur) {
        return transporteurRepository.save(transporteur);
    }

    @Override
    public void deleteTransporteur(Long id) {
    	transporteurRepository.deleteById(id);
    }

    @Override
    public List<Transporteur> getAllTransporteur() {
        return transporteurRepository.findAll();
    }

    @Override
    public Transporteur getTransporteurById(Long id) {
        return transporteurRepository.findById(id).get();
    }

}
