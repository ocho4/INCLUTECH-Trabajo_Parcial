package com.upc.inclutechtrabajo_parcial.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "recursoseducativos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecursoEducativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;
    private String descripcion;

    @OneToMany(mappedBy = "recurso")
    private List<RecursoEducativoFavoritoUsuario> favoritos;

    @OneToMany(mappedBy = "recursoEducativo")
    private List<CategoriaRecursoEducativo> categorias;
}