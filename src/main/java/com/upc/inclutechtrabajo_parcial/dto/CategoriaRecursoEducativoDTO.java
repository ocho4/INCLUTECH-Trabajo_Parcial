package com.upc.inclutechtrabajo_parcial.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriaRecursoEducativoDTO {
    private Integer id;
    private String descripcionRecurso;
    private Integer recursoId;
    private Integer categoriaId;
}