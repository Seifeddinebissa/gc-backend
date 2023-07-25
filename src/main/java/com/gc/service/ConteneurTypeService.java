package com.gc.service;

import com.gc.entity.ConteneurType;

import java.util.List;

public interface ConteneurTypeService {
    ConteneurType addConteneurType(ConteneurType conteneurType);
    ConteneurType updateConteneurType(ConteneurType conteneurType);
    void deleteConteneurType(Long id);
    ConteneurType getConteneurTypeById(Long id);
    List<ConteneurType> getAllConteneurType();
}
