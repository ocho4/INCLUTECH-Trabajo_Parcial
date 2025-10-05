package com.upc.inclutechtrabajo_parcial.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comentarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String contenido;
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "publicacion_id")
    private PublicacionForo publicacion;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}