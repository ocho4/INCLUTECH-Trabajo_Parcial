package com.upc.inclutechtrabajo_parcial.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecursoEducativoFavoritoUsuarioDTO {
    private Integer id;
    private LocalDateTime fechaAgregado;
    private Integer usuarioId;
    private Integer recursoId;
}