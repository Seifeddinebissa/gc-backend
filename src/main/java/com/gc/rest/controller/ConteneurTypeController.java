package com.gc.rest.controller;

import com.gc.entity.ConteneurType;
import com.gc.rest.dto.ConteneurTypeDto;
import com.gc.service.ConteneurTypeService;
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
public class ConteneurTypeController {

    @Autowired
    ConteneurTypeService conteneurTypeService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/conteneurType")
    public Object getAllConeteneurTypes(){
        List<ConteneurType> conteneurTypes = conteneurTypeService.getAllConteneurType();
        Type listType = new TypeToken<List<ConteneurTypeDto>>(){}.getType();
        List<ConteneurTypeDto> conteneurTypeDtos = modelMapper.map(conteneurTypes, listType);
        return ResponseEntity.status(HttpStatus.CREATED).body(conteneurTypeDtos);
    }

    @GetMapping("/conteneurType/{id}")
    public Object getConteneurById(@PathVariable Long id) {
        ConteneurType conteneurType = conteneurTypeService.getConteneurTypeById(id);
        ConteneurTypeDto conteneurTypeDto = modelMapper.map(conteneurType, ConteneurTypeDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(conteneurTypeDto);
    }

    @PostMapping("/conteneurType")
    public Object addConteneurType(@RequestBody ConteneurTypeDto conteneurTypeDto){
        ConteneurType conteneurType = modelMapper.map(conteneurTypeDto, ConteneurType.class);
        conteneurType = conteneurTypeService.addConteneurType(conteneurType);
        conteneurTypeDto = modelMapper.map(conteneurType, ConteneurTypeDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(conteneurTypeDto);
    }

    @DeleteMapping("/conteneurType/{id}")
    public Object deleteConteneur(@PathVariable Long id) {
        conteneurTypeService.deleteConteneurType(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @PutMapping("/conteneurType")
    public Object updateConteneurType(@RequestBody ConteneurTypeDto conteneurTypeDto){
        ConteneurType conteneurType = modelMapper.map(conteneurTypeDto, ConteneurType.class);
        conteneurType = conteneurTypeService.updateConteneurType(conteneurType);
        conteneurTypeDto = modelMapper.map(conteneurType, ConteneurTypeDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(conteneurTypeDto);
    }
}
