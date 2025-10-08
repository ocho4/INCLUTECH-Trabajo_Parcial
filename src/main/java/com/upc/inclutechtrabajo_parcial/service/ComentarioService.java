package com.upc.inclutechtrabajo_parcial.service;

import com.upc.inclutechtrabajo_parcial.dto.ComentarioDTO;
import com.upc.inclutechtrabajo_parcial.model.Comentario;
import com.upc.inclutechtrabajo_parcial.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComentarioService {
    @Autowired
    private ComentarioRepository comentarioRepository;

    public Comentario registrar(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public List<ComentarioDTO> listar() {
        return comentarioRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public ComentarioDTO actualizar(Integer id, ComentarioDTO dto) {
        Comentario existente = comentarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentario con ID " + id + " no encontrado"));
        existente.setContenido(dto.getContenido());
        existente.setFecha(dto.getFecha());
        Comentario actualizado = comentarioRepository.save(existente);
        return convertirADTO(actualizado);
    }

    public void eliminar(Integer id) {
        if (!comentarioRepository.existsById(id)) {
            throw new RuntimeException("Comentario con ID " + id + " no encontrado");
        }
        comentarioRepository.deleteById(id);
    }

    private ComentarioDTO convertirADTO(Comentario comentario) {
        return ComentarioDTO.builder()
                .id(comentario.getId())
                .contenido(comentario.getContenido())
                .fecha(comentario.getFecha())
                .publicacionId(comentario.getPublicacion() != null ? comentario.getPublicacion().getId() : null)
                .usuarioId(comentario.getUsuario() != null ? comentario.getUsuario().getId() : null)
                .build();
    }

}
