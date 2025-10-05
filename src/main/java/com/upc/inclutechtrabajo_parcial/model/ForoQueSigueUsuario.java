package com.upc.inclutechtrabajo_parcial.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "forosquesigueusuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ForoQueSigueUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime fechaSeguimiento;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "foro_id")
    private Foro foro;
}