package com.gc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Parc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "addresse")
    private String addresse;
    @Column(name = "capacite")
    private Integer capacite;

    @JsonIgnore
    @OneToMany(mappedBy = "parc", cascade = CascadeType.REMOVE)
    private List<Conteneur>  conteneurs;
}
