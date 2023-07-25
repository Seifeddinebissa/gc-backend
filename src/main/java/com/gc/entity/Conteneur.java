package com.gc.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.gc.rest.dto.LastDemandeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@NamedNativeQuery(
		name = "Demande.findConteneursNotInDemande",
		query = "SELECT id, marquage FROM Conteneur c WHERE c.id NOT IN (SELECT conteneur_id FROM demande)",
		resultSetMapping = "ConteneursNotInDemande"
)
@SqlResultSetMapping(
		name = "ConteneursNotInDemande",
		classes = @ConstructorResult(
				targetClass = ConteneurNoInDemande.class,
				columns = {
						@ColumnResult(name = "id", type = Long.class),
						@ColumnResult(name = "marquage", type = String.class)
				}
		)
)
public class Conteneur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name ="couleur1")
	private String couleur1;
	@Column(name = "taille")
	private String taille;
	@Column(name = "couleur2")
	private String couleur2;
	@Column(name ="marquage")
	private String marquage;
	@Column(name = "status")
	private String status; 
	

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "arm_id")
    private Armateur armateur;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typeConteneur_id")
    private ConteneurType conteneurType;

	@JsonIgnore
	@OneToMany(mappedBy = "conteneur", cascade = CascadeType.ALL)
	private List<Demande> demandes;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parc_id")
	private Parc parc;
}
