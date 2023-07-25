package com.gc.rest.controller;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

import com.gc.entity.Demande;
import com.gc.entity.Eir;
import com.gc.entity.Transporteur;
import com.gc.rest.dto.EirDto;
import com.gc.service.DemandeService;
import com.gc.service.EirService;
import com.gc.service.TransporteurService;

@RestController
@CrossOrigin("*")
public class EirController {
	@Autowired
    EirService eirService;
	@Autowired
    DemandeService demandeService;
    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/eir/{id}")
    public Object getEIRById(@PathVariable Long id) {
        Eir eir = eirService.getEIRById(id);
        EirDto eirDto = modelMapper.map(eir, EirDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(eirDto);
    }

    @GetMapping("/eir")
    public Object getAllEIR() {
        List<Eir> eirs = eirService.getAllEIR();
        Type listType = new TypeToken<List<EirDto>>() {}.getType();
        List<EirDto> eirDtos = modelMapper.map(eirs, listType);
        return ResponseEntity.status(HttpStatus.CREATED).body(eirDtos);
    }

    @PostMapping("/eir/demande/{idD}")
    public Object addEIR(@RequestBody EirDto eirDto, @PathVariable Long idD) {
        Eir eir = modelMapper.map(eirDto, Eir.class);
        Demande demande= demandeService.getDemandeById(idD);
        eir.setDemande(demande);
        eir = eirService.addEIR(eir);
        eirDto = modelMapper.map(eir, EirDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(eirDto);
    }

    @DeleteMapping("/eir/{id}")
    public Object deleteEIR(@PathVariable Long id) {
        eirService.deleteEIR(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @PutMapping("/eir/demande/{idD}")
    public Object updateEIR(@RequestBody EirDto eirDto, @PathVariable Long idD) {
    	Eir eir = modelMapper.map(eirDto, Eir.class);
    	Demande demande=demandeService.getDemandeById(idD);
    	eir.setDemande(demande);
        eir = eirService.updateEIR(eir);
        eirDto = modelMapper.map(eir, EirDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(eirDto);
    }
    @GetMapping("/eir/countAll/")
	public Object countAll() {
		Integer nbr = eirService.getAllEIR().size();
		return ResponseEntity.status(HttpStatus.CREATED).body(nbr);
	}

    @GetMapping("/eir/demande/{id}")
    public Object findByDemandeId(@PathVariable Long id) {
        try {
            Eir eir = eirService.findEIRByDemande(id);
            EirDto eirDto = modelMapper.map(eir,EirDto.class);
            return ResponseEntity.status(HttpStatus.CREATED).body(eirDto);
        }catch(IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }
    
    @GetMapping("/eir/countByAgent/{idAgent}")
	public Object countByAgent(@PathVariable Long idAgent) {
		Integer nbr = eirService.getNbrEIRByAgentId(idAgent);
		return ResponseEntity.status(HttpStatus.CREATED).body(nbr);
	}
    @GetMapping("/eir/countByArm/{idArm}")
  	public Object countByArmateur(@PathVariable Long idArm) {
  		Integer nbr = eirService.getNbrEIRByArmateurId(idArm);
  		return ResponseEntity.status(HttpStatus.CREATED).body(nbr);
  	}
}
