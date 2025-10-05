package com.upc.inclutechtrabajo_parcial.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "foros")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Foro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;
    private String descripcion;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnore
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    @JsonIgnore
    private Categoria categoria;

    @OneToMany(mappedBy = "foro")
    @JsonIgnore
    private List<PublicacionForo> publicaciones;

    @OneToMany(mappedBy = "foro")
    @JsonIgnore
    private List<ForoQueSigueUsuario> seguidores;
}