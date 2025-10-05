package com.upc.inclutechtrabajo_parcial.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PublicacionForoDTO {
    private Integer id;
    private String titulo;
    private String contenido;
    private LocalDateTime fecha;
    private Integer foroId;
    private Integer usuarioId;
}