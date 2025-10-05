package com.upc.inclutechtrabajo_parcial.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriaDTO {
    private Integer id;
    private String nombre;
    private String descripcion;
}