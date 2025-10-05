package com.upc.inclutechtrabajo_parcial.repository;

import com.upc.inclutechtrabajo_parcial.model.Foro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ForoRepository extends JpaRepository<Foro, Integer> {
    // 1. Foros por categoría
    @Query("SELECT f FROM Foro f WHERE f.categoria.id = :idCategoria")
    List<Foro> findByCategoriaId(@Param("idCategoria") Integer idCategoria);

    // 2. Foros entre dos fechas (rango)
    @Query("SELECT f FROM Foro f WHERE f.fechaCreacion BETWEEN :inicio AND :fin")
    List<Foro> findByRangoFechas(@Param("inicio") LocalDateTime inicio, @Param("fin") LocalDateTime fin);

    // 3. Foros desde cierta fecha (>=)
    @Query("SELECT f FROM Foro f WHERE f.fechaCreacion >= :fechaDesde")
    List<Foro> findDesdeFecha(@Param("fechaDesde") LocalDateTime fechaDesde);

    // 4. Foros ordenados recientes primero
    @Query("SELECT f FROM Foro f ORDER BY f.fechaCreacion DESC")
    List<Foro> findRecientes();

    // 5. Foros seguidos por un usuario (usa la relación Foro.seguidores -> ForoQueSigueUsuario)
    @Query("SELECT f FROM Foro f JOIN f.seguidores s WHERE s.usuario.id = :idUsuario")
    List<Foro> findForosSeguidosPorUsuario(@Param("idUsuario") Integer idUsuario);

    List<Foro> findByUsuario_Id(Integer usuarioId);
}
