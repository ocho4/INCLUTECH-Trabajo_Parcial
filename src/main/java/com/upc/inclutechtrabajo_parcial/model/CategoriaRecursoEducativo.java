package com.upc.inclutechtrabajo_parcial.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categoriasrecursoseduc")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriaRecursoEducativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descripcion_recurso")
    private String descripcionRecurso;

    @ManyToOne
    @JoinColumn(name = "recursoseducativos_id")
    private RecursoEducativo recursoEducativo;

    @ManyToOne
    @JoinColumn(name = "categorias_id")
    private Categoria categoria;
}