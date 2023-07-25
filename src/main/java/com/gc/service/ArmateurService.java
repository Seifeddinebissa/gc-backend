package com.gc.service;

import com.gc.entity.Armateur;

import java.util.List;

public interface ArmateurService {

    Armateur addArmateur(Armateur armateur);
    Armateur updateArmateur(Armateur armateur);
    void deleteArmateur(Long id);
    List<Armateur> getAllArmateur();
    Armateur getArmateurById(Long id);
    Armateur findByUserId(Long id);
    Armateur findByEmail(String email);
}
