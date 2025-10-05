package com.upc.inclutechtrabajo_parcial.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecursoEducativoDTO {
    private Integer id;
    private String titulo;
    private String descripcion;
}