package com.gc.rest.controller;

import com.gc.entity.Dommage;
import com.gc.entity.Eir;
import com.gc.service.EirService;
import net.bytebuddy.description.method.MethodDescription;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gc.entity.DommageItem;
import com.gc.rest.dto.DommageItemDto;
import com.gc.service.DommageItemService;
import com.gc.service.DommageService;

import java.lang.reflect.Type;
import java.util.List;

@CrossOrigin("*")
@RestController
public class DommageItemController {

	@Autowired
	DommageService dommageService;

	@Autowired
	DommageItemService itemService;

	@Autowired
	EirService eirService;

	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/dommageItem/{id}")
	public Object getById(@PathVariable Long id) {
		DommageItem item = itemService.getById(id);
		DommageItemDto itemDto = modelMapper.map(item,DommageItemDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(itemDto);
	}
	@GetMapping("/dommageItem")
	public Object getAll(){
		List<DommageItem> dommageItems = itemService.getAll();
		Type listType = new TypeToken<List<DommageItemDto>>(){}.getType();
		List<DommageItemDto> dommageItemDtos = modelMapper.map(dommageItems, listType);
		return  ResponseEntity.status(HttpStatus.CREATED).body(dommageItemDtos);
	}

	@GetMapping("/dommageItem/eir/{id}")
	public Object getAllByEirId(@PathVariable Long id) {
		List<DommageItem> dommageItems = itemService.getAllByEirId(id);
		Type listType = new TypeToken<List<DommageItemDto>>(){}.getType();
		List<DommageItemDto> dommageItemDtos = modelMapper.map(dommageItems, listType);
		return ResponseEntity.status(HttpStatus.CREATED).body(dommageItemDtos);
	}
	@PostMapping("/dommageItem/dommage/{idDom}/eir/{idEir}")
	public Object addDommageItem(@RequestBody DommageItemDto dommageItemDto, @PathVariable Long idDom, @PathVariable Long idEir){
		DommageItem dommageItem = modelMapper.map(dommageItemDto, DommageItem.class);
		Dommage dommage = dommageService.getDommageById(idDom);
		dommageItem.setDommage(dommage);
		Eir eir = eirService.getEIRById(idEir);
		dommageItem.setEir(eir);
		dommageItem = itemService.addItem(dommageItem);
		dommageItemDto = modelMapper.map(dommageItem, DommageItemDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(dommageItemDto);
	}

	@PutMapping("/dommageItem/dommage/{idDom}/eir/{idEir}")
	public Object editDommageItem(@RequestBody DommageItemDto dommageItemDto, @PathVariable Long idDom, @PathVariable Long idEir){
		DommageItem dommageItem = modelMapper.map(dommageItemDto, DommageItem.class);
		Dommage dommage = dommageService.getDommageById(idDom);
		dommageItem.setDommage(dommage);
		Eir eir = eirService.getEIRById(idEir);
		dommageItem.setEir(eir);
		dommageItem = itemService.addItem(dommageItem);
		dommageItemDto = modelMapper.map(dommageItem, DommageItemDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(dommageItemDto);
	}
	@DeleteMapping("/dommageItem/{id}")
	public Object delete(@PathVariable Long id) {
		itemService.deletById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
}
