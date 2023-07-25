package com.gc.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Eir {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "date")
	private String date;
	@Column(name = "time")
	private String time;
	@Column(name = "chargeur")
	private String chargeur;
	@Column(name = "numSeal")
	private String numSeal;
	@Column(name = "num_Vehicule")
	private String numVehicule;
	@Column(name = "de")
	private String de;
	@Column(name = "jusqua")
	private String jusqua;
	@Column(name = "phase")
	private String phase;
	@Column(name = "remarque")
	private String remarque;
	
	@OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "demd_id", referencedColumnName = "id")
    private Demande demande;

	@OneToMany(mappedBy = "eir",cascade = CascadeType.REMOVE)
	private List<DommageItem> dommageItems;
	
	
	
	
}
