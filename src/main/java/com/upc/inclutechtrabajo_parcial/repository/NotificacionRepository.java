package com.upc.inclutechtrabajo_parcial.repository;

import com.upc.inclutechtrabajo_parcial.model.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotificacionRepository extends JpaRepository<Notificacion, Integer> {
    // Query 1: muestra los usuarios con más notificaciones

    @Query("SELECT u.id, u.nombre, COUNT(n) " +
            "FROM Notificacion n " +
            "JOIN n.usuarioSigueForo fsu " +
            "JOIN fsu.usuario u " +
            "GROUP BY u.id, u.nombre " +
            "ORDER BY COUNT(n) DESC")
    List<Object[]> obtenerUsuariosConMasNotificaciones();
}
