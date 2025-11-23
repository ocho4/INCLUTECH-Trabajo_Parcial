package com.upc.inclutechtrabajo_parcial.repository;

import com.upc.inclutechtrabajo_parcial.model.PublicacionForo;
import com.upc.inclutechtrabajo_parcial.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PublicacionForoRepository extends JpaRepository<PublicacionForo, Integer> {
    Optional<Object> findByUsuario(Usuario usuario);
    // 1. Buscar publicaciones por ID de usuario
    @Query("SELECT p FROM PublicacionForo p WHERE p.usuario.id = :idUsuario")
    List<PublicacionForo> findByUsuarioId(@Param("idUsuario") Long idUsuario);

    // 2. Buscar publicaciones por ID de foro
    @Query("SELECT p FROM PublicacionForo p WHERE p.foro.id = :idForo")
    List<PublicacionForo> findByForoId(@Param("idForo") Long idForo);

    // 3. Buscar publicaciones por palabra clave en el título
    @Query("SELECT p FROM PublicacionForo p WHERE LOWER(p.titulo) LIKE LOWER(CONCAT('%', :palabra, '%'))")
    List<PublicacionForo> findByTituloContaining(@Param("palabra") String palabra);
}
