package com.gc.rest.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgentParcDto {
	 private Long id;
	 private String nom;
	 private String prenom;
	 private String addresse;
	 private String tel;
	 private String email;
	 private UserDto user;
}
