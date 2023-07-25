package com.gc.entity;

import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "UTILISATEUR")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "PSEUDO")
	private String pseudo;

	@Column(name = "MOT_DE_PASSE")
	private String mdp;

	@Column(name = "ROLE")
	private String role;

	@Column(name = "BLOCKED")
	private Boolean blocked;

	@Column(name = "DATE_CREATION")
	private Date dateCreation;

	@OneToOne(mappedBy = "user")
	private Armateur armateur;
	
	@OneToOne(mappedBy = "user")
	private AgentParc agentParc;

}
