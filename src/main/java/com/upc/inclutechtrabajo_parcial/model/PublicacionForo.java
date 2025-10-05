package com.upc.inclutechtrabajo_parcial.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "publicacionesforos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PublicacionForo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;
    private String contenido;
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "foro_id")
    @JsonIgnore
    private Foro foro;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnore
    private Usuario usuario;

    @OneToMany(mappedBy = "publicacion")
    @JsonIgnore
    private List<Comentario> comentarios;
}