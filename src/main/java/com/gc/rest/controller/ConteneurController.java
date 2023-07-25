package com.gc.rest.controller;

import java.lang.reflect.Type;
import java.util.List;

import com.gc.entity.ConteneurNoInDemande;
import com.gc.rest.dto.LastDemandeDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.gc.entity.Armateur;
import com.gc.entity.Conteneur;
import com.gc.entity.ConteneurType;
import com.gc.rest.dto.ConteneurDto;
import com.gc.service.ArmateurService;
import com.gc.service.ConteneurService;
import com.gc.service.ConteneurTypeService;


@CrossOrigin("*")
@RestController
public class ConteneurController {
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	ConteneurService conteneurService;
    @Autowired
    ArmateurService armateurService;
    @Autowired
    ConteneurTypeService conteneurTypeService;
	@GetMapping("/conteneur/{id}")
	public Object getConteneur(@PathVariable Long id) {
		Conteneur ctn = conteneurService.getConteneur(id);
		ConteneurDto conteneurDto = modelMapper.map(ctn, ConteneurDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(conteneurDto);
	}

	@GetMapping("/conteneur")
	public Object getAllConteneurs() {
		List<Conteneur> ctns = conteneurService.getAllConteneurs();
		Type listType = new TypeToken<List<ConteneurDto>>() {
		}.getType();
		List<ConteneurDto> conteneurDto = modelMapper.map(ctns, listType);
		return ResponseEntity.status(HttpStatus.CREATED).body(conteneurDto);
	}
   
	@DeleteMapping("/conteneur/{id}")
	public Object deleteConteneur(@PathVariable Long id) {
		conteneurService.deleteConteneurById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

	}
	 @PostMapping("/conteneur/armateur/{idA}/conteneurType/{idTC}")
	    public Object addConteneur(@RequestBody ConteneurDto conteneurDto, @PathVariable Long idA, @PathVariable Long idTC) {
	        Conteneur conteneur = modelMapper.map(conteneurDto, Conteneur.class);
	        Armateur armateur= armateurService.getArmateurById(idA);
	        ConteneurType conteneurType= conteneurTypeService.getConteneurTypeById(idTC);
	        conteneur.setArmateur(armateur);
	        conteneur.setConteneurType(conteneurType);
	        conteneur = conteneurService.addConteneur(conteneur);
	        conteneurDto = modelMapper.map(conteneur, ConteneurDto.class);
	        return ResponseEntity.status(HttpStatus.CREATED).body(conteneurDto);
	    }
	 @PutMapping("/conteneur/armateur/{idA}/conteneurType/{idTC}")
	    public Object updateConteneur(@RequestBody ConteneurDto conteneurDto, @PathVariable Long idA, @PathVariable Long idTC) {
	        Conteneur conteneur = modelMapper.map(conteneurDto, Conteneur.class);
		 	Armateur armateur= armateurService.getArmateurById(idA);
		 	ConteneurType conteneurType= conteneurTypeService.getConteneurTypeById(idTC);
			 conteneur.setArmateur(armateur);
			 conteneur.setConteneurType(conteneurType);
	        conteneur = conteneurService.updateConteneur(conteneur);
	        conteneurDto = modelMapper.map(conteneur, ConteneurDto.class);
	        return ResponseEntity.status(HttpStatus.CREATED).body(conteneurDto);
	    }
	 @GetMapping("/conteneur/armateur/{id}")
	    public Object findByArmateurId(@PathVariable Long id){
	        List<Conteneur> conteneurs = conteneurService.findByArmateurId(id);
	        Type listType = new TypeToken<List<ConteneurDto>>() {
			}.getType();
	        List<ConteneurDto> conteneurDto = modelMapper.map(conteneurs, listType);
	        return ResponseEntity.status(HttpStatus.CREATED).body(conteneurDto);
	    }
	@GetMapping("/conteneur/typeConteneur/{id}")
	    public Object findByTypeConteneurId(@PathVariable Long id){
	        List<Conteneur> conteneurs = conteneurService.findByTypeConteneur(id);
	        Type listType = new TypeToken<List<ConteneurDto>>() {
			}.getType();
	        List<ConteneurDto> conteneurDto = modelMapper.map(conteneurs, listType);
	        return ResponseEntity.status(HttpStatus.CREATED).body(conteneurDto);
	    }
	 @GetMapping("/conteneur/armateur/{id}/status/{status}")
	    public Object findByArmateurIdAndStatus(@PathVariable Long id, @PathVariable String status){
	        List<Conteneur> conteneurs = conteneurService.getByArmateurAndStatus(id, status);
	        Type listType = new TypeToken<List<ConteneurDto>>() {
			}.getType();
	        List<ConteneurDto> conteneurDto = modelMapper.map(conteneurs, listType);
	        return ResponseEntity.status(HttpStatus.CREATED).body(conteneurDto);
	    }

	@GetMapping("/conteneur/notInDemande")
	public Object findByArmateurIdAndStatus(){
		List<ConteneurNoInDemande> conteneurs = conteneurService.findConteneurNotInDemande();
		Type listType = new TypeToken<List<LastDemandeDto>>() {
		}.getType();
		List<LastDemandeDto> conteneurDto = modelMapper.map(conteneurs, listType);
		return ResponseEntity.status(HttpStatus.CREATED).body(conteneurDto);
	}
	
	@GetMapping("/conteneur/parc/{id}")
    public Object getByParc(@PathVariable Long id){
        List<Conteneur> conteneurs = conteneurService.getByParcId(id);
        Type listType = new TypeToken<List<ConteneurDto>>() {
		}.getType();
        List<ConteneurDto> conteneurDto = modelMapper.map(conteneurs, listType);
        return ResponseEntity.status(HttpStatus.CREATED).body(conteneurDto);
    }

	@GetMapping("/conteneur/exist/{marquage}")
	public Object getConteneurByMarquage(@PathVariable String marquage) {
		Boolean exist = conteneurService.conteneurExist(marquage);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(exist);
	}
}
