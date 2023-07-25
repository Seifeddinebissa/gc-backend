package com.gc.service;

import com.gc.entity.Parc;

import java.util.List;

public interface ParcService {
    Parc getParcById(Long id);
    Parc addParc(Parc parc);
    Parc updateParc(Parc parc);
    void deleteParc(Long id);
    List<Parc> getAllParcs();
}
