package com.gc.rest.controller;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gc.entity.*;
import com.gc.rest.dto.LastDemandeDto;
import com.gc.service.*;
import net.bytebuddy.description.method.MethodDescription;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.gc.rest.dto.DemandeDto;

@RestController
@CrossOrigin("*")
public class DemandeController {
	    @Autowired
	    DemandeService demandeService;
	    
	    @Autowired
	    ArmateurService armateurService;
	    
	    @Autowired
	    AgentParcService agentService;
	    
	    @Autowired
	    ConteneurService conteneurService;
		@Autowired
		TransporteurService transporteurService;

	    @Autowired
	    ModelMapper modelMapper;

	    @GetMapping("/demande/{id}")
	    public Object getDemandeById(@PathVariable Long id) {
	        Demande demande = demandeService.getDemandeById(id);
	        DemandeDto demandeDto = modelMapper.map(demande, DemandeDto.class);
	        return ResponseEntity.status(HttpStatus.CREATED).body(demandeDto);
	    }

	    @GetMapping("/demande")
	    public Object getAllDemande() {
	        List<Demande> demandes = demandeService.getAllDemande();
	        Type listType = new TypeToken<List<DemandeDto>>() {}.getType();
	        List<DemandeDto> demandeDtos = modelMapper.map(demandes, listType);
	        return ResponseEntity.status(HttpStatus.CREATED).body(demandeDtos);
	    }

	@PostMapping("/demande/conteneur/{idCtr}/armateur/{idArm}/transporteur/{idTr}")
	public Object addDemande(@RequestBody DemandeDto demandeDto, @PathVariable Long idCtr, @PathVariable Long idArm, @PathVariable Long idTr){
		Demande demande = modelMapper.map(demandeDto, Demande.class);
		Armateur armateur = armateurService.getArmateurById(idArm);
		Conteneur conteneur = conteneurService.getConteneur(idCtr);
		if(idTr != -1){
			Transporteur transporteur = transporteurService.getTransporteurById(idTr);
			demande.setTransporteur(transporteur);
		}else{
			demande.setTransporteur(null);
		}
		demande.setArm(armateur);
		demande.setConteneur(conteneur);
		demande = demandeService.addDemande(demande);
		demandeDto = modelMapper.map(demande, DemandeDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(demandeDto);
	}

	    @DeleteMapping("/demande/{id}")
	    public Object deleteDemande(@PathVariable Long id) {
	        demandeService.deleteDemande(id);
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	    }

	    @PutMapping("/demande/conteneur/{idCtr}/armateur/{idArm}/agent/{idAg}/transporteur/{idTr}")
	    public Object updateDemande(@RequestBody DemandeDto demandeDto, @PathVariable Long idCtr, @PathVariable Long idArm, @PathVariable Long idAg, @PathVariable Long idTr) {
	    	  Demande demande = modelMapper.map(demandeDto, Demande.class);
	    	  demande.setDateCreation(demandeService.getDemandeById(demande.getId()).getDateCreation());
	    	  demande.setDateTraitement(demandeService.getDemandeById(demande.getId()).getDateTraitement());
	  		  Armateur armateur = armateurService.getArmateurById(idArm);
			  Conteneur conteneur = conteneurService.getConteneur(idCtr);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
				if (idAg != -1) {
					AgentParc agentParc = agentService.getAgentParc(idAg);
					demande.setAgent(agentParc);
				} else {
					demande.setAgent(null);
				}
			if (idTr != -1) {
				Transporteur transporteur = transporteurService.getTransporteurById(idTr);
				demande.setTransporteur(transporteur);
			} else {
				demande.setTransporteur(null);
			}
			  demande.setDateCreation(this.demandeService.getDemandeById(demandeDto.getId()).getDateCreation());
			  demande.setArm(armateur);
			  demande.setConteneur(conteneur);
			  demande.setUpdateTime(LocalDateTime.now().format(formatter));
	          demande = demandeService.updateDemande(demande);
	          demandeDto = modelMapper.map(demande, DemandeDto.class);
	          return ResponseEntity.status(HttpStatus.CREATED).body(demandeDto);
	    }
	    
	    @GetMapping("/demande/ByArmateurId/{id}")
	    public Object findByArmId(@PathVariable Long id){
	        List<Demande> demandes = demandeService.findByArmateurId(id);
	        Type listType = new TypeToken<List<DemandeDto>>() {
			}.getType();
	        List<DemandeDto> demandeDto = modelMapper.map(demandes, listType);
	        return ResponseEntity.status(HttpStatus.CREATED).body(demandeDto);
	    }
	    @GetMapping("/demande/ByAgentId/{id}")
	    public Object findByAgentId(@PathVariable Long id){
	        List<Demande> demandes = demandeService.findByAgentId(id);
	        Type listType = new TypeToken<List<DemandeDto>>() {
			}.getType();
	        List<DemandeDto> demandeDto = modelMapper.map(demandes, listType);
	        return ResponseEntity.status(HttpStatus.CREATED).body(demandeDto);
	    }
	@GetMapping("/demande/dateCreation/{date}")
	public Object findByDateCreation( @PathVariable String date) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse(date);
		List<Demande> demandes = demandeService.findByDateCreation(d);
		Type listType = new TypeToken<List<DemandeDto>>() {
		}.getType();
		List<DemandeDto> demandeDto = modelMapper.map(demandes, listType);
		return ResponseEntity.status(HttpStatus.CREATED).body(demandeDto);
	}

	@GetMapping("/demande/lastDemande/traite")
	public Object findLastDemandeTraite(){
		List<LastDemandeDto> demandes = demandeService.findLastDemandeTraite();
		return ResponseEntity.status(HttpStatus.CREATED).body(demandes);
	}

	@GetMapping("/demande/dateModification/{date}")
	public Object findByUpdateTimeContains(@PathVariable String date){
		List<Demande> demandes = demandeService.findByUpdateTimeContains(date);
		Type listType = new TypeToken<List<DemandeDto>>() {
		}.getType();
		List<DemandeDto> demandeDto = modelMapper.map(demandes, listType);
		return ResponseEntity.status(HttpStatus.CREATED).body(demandeDto);
	}
}
