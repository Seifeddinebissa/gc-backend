package com.gc.rest.controller;

import com.gc.entity.Transporteur;
import com.gc.rest.dto.TransporteurDto;
import com.gc.service.TransporteurService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;


@RestController
@CrossOrigin("*")
public class TransporteurController {

    @Autowired
    TransporteurService transporteurService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/transporteur/{id}")
    public Object getArmateurById(@PathVariable Long id) {
    	Transporteur bateau = transporteurService.getTransporteurById(id);
    	TransporteurDto transporteurDto = modelMapper.map(bateau, TransporteurDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(transporteurDto);
    }

    @GetMapping("/transporteur")
    public Object getAllTransporteur() {
        List<Transporteur> transporteur = transporteurService.getAllTransporteur();
        Type listType = new TypeToken<List<TransporteurDto>>() {}.getType();
        List<TransporteurDto> transporteurDtos = modelMapper.map(transporteur, listType);
        return ResponseEntity.status(HttpStatus.CREATED).body(transporteurDtos);
    }

    @PostMapping("/transporteur")
    public Object addTransporteur(@RequestBody TransporteurDto transporteurDto) {
    	Transporteur transporteur = modelMapper.map(transporteurDto, Transporteur.class);
    	transporteur = transporteurService.addTransporteur(transporteur);
        transporteurDto = modelMapper.map(transporteur, TransporteurDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(transporteurDto);
    }

    @DeleteMapping("/transporteur/{id}")
    public Object deleteTransporteur(@PathVariable Long id) {
    	transporteurService.deleteTransporteur(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @PutMapping("/transporteur")
    public Object updateTransporteur(@RequestBody TransporteurDto transporteurDto) {
    	Transporteur transporteur = modelMapper.map(transporteurDto, Transporteur.class);
    	transporteur.setDateCreation(transporteurService.getTransporteurById(transporteur.getId()).getDateCreation());
    	transporteur = transporteurService.updateTransporteur(transporteur);
    	transporteurDto = modelMapper.map(transporteur, TransporteurDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(transporteurDto);
    }

}
