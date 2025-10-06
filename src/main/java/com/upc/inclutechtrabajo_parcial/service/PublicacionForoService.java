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

    public List<PublicacionForo> listar() {
        return publicacionRepository.findAll();
    }

    public void eliminar(Integer id) {
        if (!publicacionRepository.existsById(id)) {
            throw new RuntimeException("Publicación con ID " + id + " no encontrada");
        }
        publicacionRepository.deleteById(id);
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
        dto.setUsuarioId(p.getUsuario().getId());
        dto.setForoId(p.getForo().getId());
        return dto;
    }
}
