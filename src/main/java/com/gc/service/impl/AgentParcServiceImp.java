package com.gc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gc.entity.AgentParc;
import com.gc.repository.AgentParcRepository;
import com.gc.service.AgentParcService;

@Service
public class AgentParcServiceImp implements AgentParcService {

	@Autowired
	AgentParcRepository agentParcRepository;

	@Override
	public AgentParc addAgentParc(AgentParc ap) {
		 ap.setDateCreation(new Date());
		return agentParcRepository.save(ap);
	}

	@Override
	public AgentParc saveAgentParc(AgentParc ap) {
		return agentParcRepository.save(ap);
	}

	@Override
	public AgentParc updateAgentParc(AgentParc ap) {
		return agentParcRepository.save(ap);
	}

	@Override
	public void deleteAgentParcById(Long id) {
		agentParcRepository.deleteById(id);

	}

	@Override
	public AgentParc getAgentParc(Long id) {
		return agentParcRepository.findById(id).get();
	}

	@Override
	public List<AgentParc> getAllAgents() {
		return agentParcRepository.findAll();
	}

	@Override
	public AgentParc findByUserId(Long id) {
		return agentParcRepository.findByUserId(id);
	}

	@Override
	public AgentParc findByEmail(String email) {
		return agentParcRepository.findByEmail(email);
	}

}
