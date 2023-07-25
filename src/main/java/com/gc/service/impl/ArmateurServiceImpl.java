package com.gc.service.impl;

import com.gc.entity.Armateur;
import com.gc.repository.ArmateurRepository;
import com.gc.service.ArmateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArmateurServiceImpl implements ArmateurService {

    @Autowired
    ArmateurRepository armateurRepository;
    @Override
    public Armateur addArmateur(Armateur armateur) {
        armateur.setDateCreation(new Date());
        return armateurRepository.save(armateur);
    }

    @Override
    public Armateur updateArmateur(Armateur armateur) {
        return armateurRepository.save(armateur);
    }

    @Override
    public void deleteArmateur(Long id) {
        armateurRepository.deleteById(id);
    }

    @Override
    public List<Armateur> getAllArmateur() {
        return armateurRepository.findAll();
    }

    @Override
    public Armateur getArmateurById(Long id) {
        return armateurRepository.findById(id).get();
    }

    @Override
    public Armateur findByUserId(Long id) {
        return armateurRepository.findByUserId(id);
    }

    @Override
    public Armateur findByEmail(String email) {
        return armateurRepository.findByEmail(email);
    }
}
