package com.upc.inclutechtrabajo_parcial.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ForoQueSigueUsuarioDTO {
    private Integer id;
    private LocalDateTime fechaSeguimiento;
    private Integer usuarioId;
    private Integer foroId;
}