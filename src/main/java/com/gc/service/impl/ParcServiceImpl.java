package com.gc.service.impl;

import com.gc.entity.Parc;
import com.gc.repository.ParcRepository;
import com.gc.service.ParcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParcServiceImpl implements ParcService {

    @Autowired
    ParcRepository parcRepository;

    @Override
    public Parc getParcById(Long id) {
        return parcRepository.findById(id).get();
    }

    @Override
    public Parc addParc(Parc parc) {
        return parcRepository.save(parc);
    }

    @Override
    public Parc updateParc(Parc parc) {
        return parcRepository.save(parc);
    }

    @Override
    public void deleteParc(Long id) {
        parcRepository.deleteById(id);
    }

    @Override
    public List<Parc> getAllParcs() {
        return parcRepository.findAll();
    }
}
