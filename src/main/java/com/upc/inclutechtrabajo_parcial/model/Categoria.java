package com.upc.inclutechtrabajo_parcial.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "categorias")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "categoria")
    private List<Foro> foros;

    @OneToMany(mappedBy = "categoria")
    private List<CategoriaRecursoEducativo> recursos;
}
