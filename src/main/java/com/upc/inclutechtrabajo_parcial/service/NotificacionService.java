package com.upc.inclutechtrabajo_parcial.service;

import com.upc.inclutechtrabajo_parcial.model.Notificacion;
import com.upc.inclutechtrabajo_parcial.repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacionService {
    @Autowired
    private NotificacionRepository notificacionRepository;

    public Notificacion registrar(Notificacion notificacion) {
        return notificacionRepository.save(notificacion);
    }

    public List<Notificacion> listar() {
        return notificacionRepository.findAll();
    }

    public void eliminar(Integer id) {
        if (!notificacionRepository.existsById(id)) {
            throw new RuntimeException("Notificación con ID " + id + " no encontrada");
        }
        notificacionRepository.deleteById(id);
    }

}
