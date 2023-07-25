package com.gc.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DommageItemDto {
	private Long id;
	private String position;
	private String detail;
	private int longeur;
	private int largeur;
	private int unite;
	private String anciennete;
	private String dommageValue;
	private String phase;
	private DommageDto dommage;
	private EirDto eir;
	

}

