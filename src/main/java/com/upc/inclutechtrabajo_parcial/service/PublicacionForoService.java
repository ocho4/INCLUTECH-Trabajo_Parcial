package com.upc.inclutechtrabajo_parcial.service;

import com.upc.inclutechtrabajo_parcial.dto.PublicacionForoDTO;
import com.upc.inclutechtrabajo_parcial.model.PublicacionForo;
import com.upc.inclutechtrabajo_parcial.repository.PublicacionForoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicacionForoService {
    @Autowired
    private PublicacionForoRepository publicacionRepository;

    public PublicacionForo registrar(PublicacionForo publicacion) {
        return publicacionRepository.save(publicacion);
    }

    public List<PublicacionForoDTO> listar() {
        return publicacionRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public void eliminar(Integer id) {
        if (!publicacionRepository.existsById(id)) {
            throw new RuntimeException("Publicación con ID " + id + " no encontrada");
        }
        publicacionRepository.deleteById(id);
    }

    public PublicacionForo actualizar(Integer id, PublicacionForo publicacionActualizada) {
        PublicacionForo publicacion = publicacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publicación no encontrada con ID " + id));

        publicacion.setTitulo(publicacionActualizada.getTitulo());
        publicacion.setContenido(publicacionActualizada.getContenido());
        publicacion.setFecha(publicacionActualizada.getFecha());
        publicacion.setUsuario(publicacionActualizada.getUsuario());
        publicacion.setForo(publicacionActualizada.getForo());

        return publicacionRepository.save(publicacion);
    }

    public List<PublicacionForoDTO> filtrarPorUsuario(Long idUsuario) {
        return publicacionRepository.findByUsuarioId(idUsuario)
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public List<PublicacionForoDTO> filtrarPorForo(Long idForo) {
        return publicacionRepository.findByForoId(idForo)
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public List<PublicacionForoDTO> buscarPorTitulo(String palabra) {
        return publicacionRepository.findByTituloContaining(palabra)
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }
    private PublicacionForoDTO convertirADTO(PublicacionForo p) {
        PublicacionForoDTO dto = new PublicacionForoDTO();
        dto.setId(p.getId());
        dto.setTitulo(p.getTitulo());
        dto.setContenido(p.getContenido());
        dto.setFecha(p.getFecha());
        dto.setUsuarioId(p.getUsuario() != null ? p.getUsuario().getId() : null);
        dto.setForoId(p.getForo() != null ? p.getForo().getId() : null);
        return dto;
    }
}
