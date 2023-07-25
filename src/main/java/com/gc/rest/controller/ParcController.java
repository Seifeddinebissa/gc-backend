package com.gc.rest.controller;

import com.gc.entity.Parc;
import com.gc.rest.dto.ParcDto;
import com.gc.service.ParcService;
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
public class ParcController {

    @Autowired
    ParcService parcService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/parc/{id}")
    public Object getParcById(@PathVariable Long id){
        Parc parc = parcService.getParcById(id);
        ParcDto parcDto = modelMapper.map(parc, ParcDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(parcDto);
    }

    @GetMapping("/parc")
    public Object getAllParcs(){
        List<Parc> parcs = parcService.getAllParcs();
        Type liseType = new TypeToken<List<ParcDto>>(){}.getType();
        List<ParcDto> parcDtos = modelMapper.map(parcs, liseType);
        return ResponseEntity.status(HttpStatus.CREATED).body(parcDtos);
    }

    @PostMapping("/parc")
    public Object addParc(@RequestBody ParcDto parcDto){
        Parc parc = modelMapper.map(parcDto, Parc.class);
        parc = parcService.addParc(parc);
        parcDto = modelMapper.map(parc, ParcDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(parcDto);
    }

    @PutMapping("/parc")
    public Object updateParc(@RequestBody ParcDto parcDto){
        Parc parc = modelMapper.map(parcDto, Parc.class);
        parc = parcService.updateParc(parc);
        parcDto = modelMapper.map(parc, ParcDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(parcDto);
    }

    @DeleteMapping("/parc/{id}")
    public Object deleteParc(@PathVariable Long id){
        parcService.deleteParc(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
