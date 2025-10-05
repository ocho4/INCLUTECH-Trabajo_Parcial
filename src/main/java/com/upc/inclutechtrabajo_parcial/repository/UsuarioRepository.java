package com.upc.inclutechtrabajo_parcial.repository;

import com.upc.inclutechtrabajo_parcial.model.PublicacionForo;
import com.upc.inclutechtrabajo_parcial.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByUsername(String username);
    Optional<Usuario> findByEmail(String email);

    // 🔹 1. Filtrar usuarios por nombre de rol (Profesor, Familiar, etc.)
    @Query("SELECT u FROM Usuario u WHERE LOWER(u.rol.nombre) = LOWER(:nombreRol)")
    List<Usuario> findByRolNombreIgnoreCase(@Param("nombreRol") String nombreRol);
    //🔹 2. Filtrar Usuarios que tienen recursos educativos favoritos
    @Query("SELECT DISTINCT u FROM Usuario u JOIN RecursoEducativoFavoritoUsuario f ON u.id = f.usuario.id")
    List<Usuario> findUsuariosConFavoritos();
    //🔹 3. Usuarios que siguen foros
    @Query("SELECT DISTINCT u FROM Usuario u JOIN ForoQueSigueUsuario fsu ON u.id = fsu.usuario.id")
    List<Usuario> findUsuariosQueSiguenForos();
    //🔹 4.Obtener todas las publicaciones creadas por un usuario específico.
    @Query("SELECT p FROM PublicacionForo p WHERE p.usuario.id = :idUsuario")
    List<PublicacionForo> findByUsuarioId(@Param("idUsuario") Long idUsuario);
}
