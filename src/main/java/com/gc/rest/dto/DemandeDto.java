package com.gc.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DemandeDto {
	private Long id;
	private Long idParcDemande;
	private String marchandise;
	private String etat;
	private String typeDemande;
	private Date dateCreation;
	private String phase;
	private String updateTime;
	private ArmateurDto arm;
	private AgentParcDto agent;
	private ConteneurDto conteneur;
	private TransporteurDto transporteur;
}
