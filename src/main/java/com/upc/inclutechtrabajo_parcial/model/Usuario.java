package com.upc.inclutechtrabajo_parcial.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String contrasena;

    @ManyToOne
    @JoinColumn(name = "roles_id")
    private Rol rol;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<PublicacionForo> publicaciones;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<RecursoEducativoFavoritoUsuario> recursosFavoritos;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<ForoQueSigueUsuario> forosSeguidos;

}