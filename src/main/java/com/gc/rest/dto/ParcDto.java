package com.gc.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ParcDto {
    private Long id;
    private String name;
    private String addresse;
    private Integer capacite;
}
