package com.gc.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ArmateurDto {
    private Long id;
    private String nom;
    private String prenom;
    private String addresse;
    private String email;
    private String tel;
    private UserDto user;
}
