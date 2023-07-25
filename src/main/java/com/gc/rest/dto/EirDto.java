package com.gc.rest.dto;

import java.sql.Time;
import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.gc.entity.Demande;
import com.gc.entity.Transporteur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EirDto {
    private Long id;
    private String date;
    private String time;
    private String chargeur;
    private String numSeal;
    private String numVehicule;
    private String de;
    private String jusqua;
    private String phase;
    private String remarque;
    private DemandeDto demande;
}
