package com.upc.inclutechtrabajo_parcial.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificacionDTO {
    private Integer id;
    private String descripcion;
    private Integer usuarioSigueForoId;
}