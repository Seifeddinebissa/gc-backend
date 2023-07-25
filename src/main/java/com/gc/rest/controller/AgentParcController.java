package com.gc.rest.controller;

import com.gc.entity.User;
import com.gc.service.UserService;
import org.springframework.web.bind.annotation.RestController;

import com.gc.entity.AgentParc;
import com.gc.entity.Armateur;
import com.gc.rest.dto.AgentParcDto;
import com.gc.rest.dto.ArmateurDto;
import com.gc.service.AgentParcService;

import java.lang.reflect.Type;
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

@CrossOrigin("*")
@RestController
public class AgentParcController {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	AgentParcService agentParcService;

	@Autowired
	UserService userService;

	@GetMapping("/agentParc/{id}")
	public Object getAgentParc(@PathVariable Long id) {
		AgentParc agent = agentParcService.getAgentParc(id);
		AgentParcDto agentParcDto = modelMapper.map(agent, AgentParcDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(agentParcDto);
	}

	@GetMapping("/agentParc")
	public Object getAllAgents() {
		List<AgentParc> agents = agentParcService.getAllAgents();
		Type listType = new TypeToken<List<AgentParcDto>>() {
		}.getType();
		List<AgentParcDto> agentParcDtos = modelMapper.map(agents, listType);
		return ResponseEntity.status(HttpStatus.CREATED).body(agentParcDtos);
	}

	@DeleteMapping("/agentParc/{id}")
	public Object deleteAgentParcr(@PathVariable Long id) {
		agentParcService.deleteAgentParcById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

	}
	 @PostMapping("/agentParc/user/{id}")
	    public Object addAgentParc(@RequestBody AgentParcDto agentParcDto,@PathVariable Long id) {
	        AgentParc agentParc = modelMapper.map(agentParcDto, AgentParc.class);
			User user  = userService.getById(id);
			agentParc.setUser(user);
	        agentParc = agentParcService.addAgentParc(agentParc);
	        agentParcDto = modelMapper.map(agentParc, AgentParcDto.class);
	        return ResponseEntity.status(HttpStatus.CREATED).body(agentParcDto);
	    }
	 @PutMapping("/agentParc/user/{id}")
	    public Object updateAgentParc(@RequestBody AgentParcDto agentParcDto, @PathVariable Long id) {
	        AgentParc agentParc = modelMapper.map(agentParcDto, AgentParc.class);
	         agentParc.setDateCreation(agentParcService.getAgentParc(agentParcDto.getId()).getDateCreation());
		 	User user  = userService.getById(id);
		 	agentParc.setUser(user);
	        agentParc = agentParcService.updateAgentParc(agentParc);
	        agentParcDto = modelMapper.map(agentParc, AgentParcDto.class);
	        return ResponseEntity.status(HttpStatus.CREATED).body(agentParcDto);
	    }
	 @GetMapping("/agentParc/user/{id}")
	    public Object findByUserId(@PathVariable Long id){
	        AgentParc agentParc = agentParcService.findByUserId(id);
	        AgentParcDto agentParcDto = modelMapper.map(agentParc, AgentParcDto.class);
	        return ResponseEntity.status(HttpStatus.CREATED).body(agentParcDto);
	    }
	@GetMapping("/agentParc/email/{email}")
	public Object findByUserId(@PathVariable String email){
		AgentParc agentParc = agentParcService.findByEmail(email);
		if(agentParc!= null){
		AgentParcDto agentParcDto = modelMapper.map(agentParc, AgentParcDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(agentParcDto);
		}else{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
	}
}
