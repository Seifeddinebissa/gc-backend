package com.gc.rest.controller;

import com.gc.entity.Armateur;
import com.gc.entity.User;
import com.gc.rest.dto.ArmateurDto;
import com.gc.service.ArmateurService;
import com.gc.service.UserService;

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
public class ArmateurController {

    @Autowired
    ArmateurService armateurService;
    
    @Autowired
    UserService userService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/armateur/{id}")
    public Object getArmateurById(@PathVariable Long id) {
        Armateur armateur = armateurService.getArmateurById(id);
        ArmateurDto armateurDto = modelMapper.map(armateur, ArmateurDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(armateurDto);
    }

    @GetMapping("/armateur")
    public Object getAllArmateur() {
        List<Armateur> armateurs = armateurService.getAllArmateur();
        Type listType = new TypeToken<List<ArmateurDto>>() {}.getType();
        List<ArmateurDto> armateurDtos = modelMapper.map(armateurs, listType);
        return ResponseEntity.status(HttpStatus.CREATED).body(armateurDtos);
    }

    @PostMapping("/armateur/user/{idUser}")
    public Object addArmateur(@RequestBody ArmateurDto armateurDto, @PathVariable("idUser") Long idUser) {
        Armateur armateur = modelMapper.map(armateurDto, Armateur.class);
		try {
			User user = userService.getById(idUser);
			armateur.setUser(user);
		} catch (Exception e) {
			armateur.setUser(null);
		}
        armateur = armateurService.addArmateur(armateur);
        armateurDto = modelMapper.map(armateur, ArmateurDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(armateurDto);
    }

    @DeleteMapping("/armateur/{id}")
    public Object deleteArmateur(@PathVariable Long id) {
        armateurService.deleteArmateur(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @PutMapping("/armateur/user/{idUser}")
    public Object updateArmateur(@RequestBody ArmateurDto armateurDto, @PathVariable("idUser") Long idUser) {
        Armateur armateur = modelMapper.map(armateurDto, Armateur.class);
        armateur.setDateCreation(armateurService.getArmateurById(armateur.getId()).getDateCreation());
		try {
			User user = userService.getById(idUser);
			armateur.setUser(user);
		} catch (Exception e) {
			armateur.setUser(null);
		}
        armateur = armateurService.updateArmateur(armateur);
        armateurDto = modelMapper.map(armateur, ArmateurDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(armateurDto);
    }

    @GetMapping("/armateur/byUserId/{id}")
    public Object findByUserId(@PathVariable Long id){
        Armateur armateur = armateurService.findByUserId(id);
        ArmateurDto armateurDto = modelMapper.map(armateur, ArmateurDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(armateurDto);
    }
    @GetMapping("/armateur/email/{email}")
    public Object findByUserId(@PathVariable String email){
        Armateur armateur = armateurService.findByEmail(email);
        if(armateur!= null){
            ArmateurDto armateurDto = modelMapper.map(armateur, ArmateurDto.class);
            return ResponseEntity.status(HttpStatus.CREATED).body(armateurDto);
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }

    }

}
