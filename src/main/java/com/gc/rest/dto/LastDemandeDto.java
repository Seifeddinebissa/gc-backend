package com.gc.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LastDemandeDto {

    private Long id;
    private String marquage;
    private String type;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
}
