package com.gc.entity;





import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


import com.gc.rest.dto.LastDemandeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@NamedNativeQuery(
		name = "Demande.findLastDemandeTraite",
		query = "SELECT conteneur_id as id, marquage, type_dem as type, date_creation as date  FROM demande d1, conteneur c WHERE date_creation = (SELECT MAX(date_creation) FROM demande where conteneur_id = d1.conteneur_id ) AND etat not in ('Reçue','En cours') and d1.conteneur_id = c.id;",
		resultSetMapping = "MaxDemandeTraite"
)
@SqlResultSetMapping(
		name = "MaxDemandeTraite",
		classes = @ConstructorResult(
				targetClass = LastDemandeDto.class,
				columns = {
						@ColumnResult(name = "id", type = Long.class),
						@ColumnResult(name = "marquage", type = String.class),
						@ColumnResult(name = "type", type = String.class),
						@ColumnResult(name = "date", type = Date.class)
				}
		)
)


public class Demande {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Long id;
	    @Column(name = "phase")
	    private String phase;
	    @Column(name = "etat")
	    private String etat;
	    @Column(name = "typeDem")
	    private String typeDemande;
	    @Column(name = "dateCreation")
		@Temporal(TemporalType.DATE)
	    private Date dateCreation;
		@Temporal(TemporalType.DATE)
	    @Column(name = "dateTraitement")
	    private Date dateTraitement;
		@Column(name = "idParcDemande")
		private Long idParcDemande;
		@Column(name = "update_time")
		private String updateTime;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "arm_id")
	    private Armateur arm;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "agent_id")
	    private AgentParc agent;
	    
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "CONTENEUR_ID")
		private Conteneur conteneur;

	    @OneToOne(mappedBy = "demande")
		private Eir eir;

		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "transporteur_id")
		private Transporteur transporteur;
}
