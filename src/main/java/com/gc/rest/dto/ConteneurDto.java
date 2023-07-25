package com.gc.rest.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.gc.entity.Armateur;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConteneurDto {
	private Long id;
	private String couleur1;
	private String couleur2;
	private String taille;
	private String marquage;
	private String status;
    private ArmateurDto armateur;
    private ConteneurTypeDto conteneurType;
	private ParcDto parc;
}
