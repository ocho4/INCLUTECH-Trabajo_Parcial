package com.upc.inclutechtrabajo_parcial.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComentarioDTO {
    private Integer id;
    private String contenido;
    private LocalDateTime fecha;
    private Integer publicacionId;
    private Integer usuarioId;
}