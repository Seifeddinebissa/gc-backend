package com.gc.service;

import java.util.List;

import com.gc.entity.AgentParc;


public interface AgentParcService {
	AgentParc addAgentParc(AgentParc ap);

	AgentParc saveAgentParc(AgentParc ap);

	AgentParc updateAgentParc(AgentParc ap);

	void deleteAgentParcById(Long id);

	AgentParc getAgentParc(Long id);

	List<AgentParc> getAllAgents();
	AgentParc findByUserId(Long id);
	AgentParc findByEmail(String email);
}
