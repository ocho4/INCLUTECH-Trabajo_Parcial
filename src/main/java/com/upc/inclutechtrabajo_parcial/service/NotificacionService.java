package com.upc.inclutechtrabajo_parcial.service;

import com.upc.inclutechtrabajo_parcial.dto.NotificacionDTO;
import com.upc.inclutechtrabajo_parcial.model.Notificacion;
import com.upc.inclutechtrabajo_parcial.repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificacionService {
    @Autowired
    private NotificacionRepository notificacionRepository;

    public Notificacion registrar(Notificacion notificacion) {
        return notificacionRepository.save(notificacion);
    }

    public List<NotificacionDTO> listar() {
        return notificacionRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public Notificacion actualizar(Integer id, Notificacion notificacion) {
        if (!notificacionRepository.existsById(id)) {
            throw new RuntimeException("No se encontró la notificación con ID " + id);
        }
        notificacion.setId(id);
        return notificacionRepository.save(notificacion);
    }

    public void eliminar(Integer id) {
        if (!notificacionRepository.existsById(id)) {
            throw new RuntimeException("Notificación con ID " + id + " no encontrada");
        }
        notificacionRepository.deleteById(id);
    }

    private NotificacionDTO convertirADTO(Notificacion notificacion) {
        NotificacionDTO dto = new NotificacionDTO();
        dto.setId(notificacion.getId());
        dto.setDescripcion(notificacion.getDescripcion());
        if (notificacion.getUsuarioSigueForo() != null) {
            dto.setUsuarioSigueForoId(notificacion.getUsuarioSigueForo().getId());
        }
        return dto;
    }
}
