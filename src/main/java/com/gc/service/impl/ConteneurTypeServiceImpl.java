package com.gc.service.impl;

import com.gc.entity.ConteneurType;
import com.gc.repository.ConteneurTypeRepository;
import com.gc.service.ConteneurTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConteneurTypeServiceImpl implements ConteneurTypeService {

    @Autowired
    ConteneurTypeRepository conteneurTypeRepository;

    @Override
    public ConteneurType addConteneurType(ConteneurType conteneurType) {
        return conteneurTypeRepository.save(conteneurType);
    }

    @Override
    public ConteneurType updateConteneurType(ConteneurType conteneurType) {
        return conteneurTypeRepository.save(conteneurType);
    }

    @Override
    public void deleteConteneurType(Long id) {
        conteneurTypeRepository.deleteById(id);
    }

    @Override
    public ConteneurType getConteneurTypeById(Long id) {
        return conteneurTypeRepository.findById(id).get();
    }

    @Override
    public List<ConteneurType> getAllConteneurType() {
        return conteneurTypeRepository.findAll();
    }
}
