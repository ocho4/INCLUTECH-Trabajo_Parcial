package com.upc.inclutechtrabajo_parcial.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "recursoseducativosfavoritosus")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecursoEducativoFavoritoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fecha_agregado")
    private LocalDateTime fechaAgregado;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "recurso_id")
    private RecursoEducativo recurso;
}