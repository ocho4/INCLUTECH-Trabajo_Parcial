package com.upc.inclutechtrabajo_parcial.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "notificaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "usuariosigueforo_id")
    private ForoQueSigueUsuario usuarioSigueForo;
}