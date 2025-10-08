package com.upc.inclutechtrabajo_parcial.service;

import com.upc.inclutechtrabajo_parcial.dto.ForoDTO;
import com.upc.inclutechtrabajo_parcial.model.Foro;
import com.upc.inclutechtrabajo_parcial.repository.ForoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ForoService {
    @Autowired
    private ForoRepository foroRepository;

    public Foro registrar(Foro foro) {
        return foroRepository.save(foro);
    }

    public List<ForoDTO> listar() {
        return foroRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public Foro actualizar(Integer id, Foro foroActualizado) {
        Foro foroExistente = foroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Foro con ID " + id + " no encontrado"));

        foroExistente.setTitulo(foroActualizado.getTitulo());
        foroExistente.setDescripcion(foroActualizado.getDescripcion());
        foroExistente.setCategoria(foroActualizado.getCategoria());
        foroExistente.setUsuario(foroActualizado.getUsuario());

        return foroRepository.save(foroExistente);
    }

    public void eliminar(Integer id) {
        if (!foroRepository.existsById(id)) {
            throw new RuntimeException("Foro con ID " + id + " no encontrado");
        }
        foroRepository.deleteById(id);
    }

    private ForoDTO convertirADTO(Foro foro) {
        ForoDTO dto = new ForoDTO();
        dto.setId(foro.getId());
        dto.setTitulo(foro.getTitulo());
        dto.setDescripcion(foro.getDescripcion());
        dto.setFechaCreacion(foro.getFechaCreacion());

        if (foro.getUsuario() != null) {
            dto.setUsuarioId(foro.getUsuario().getId());
        }
        if (foro.getCategoria() != null) {
            dto.setCategoriaId(foro.getCategoria().getId());
        }

        return dto;
    }

    public List<Foro> listarPorUsuario(Integer idUsuario) { return foroRepository.findByUsuario_Id(idUsuario); }

    public List<Foro> listarPorCategoria(Integer idCategoria) { return foroRepository.findByCategoriaId(idCategoria); }

    public List<Foro> listarPorFechas(LocalDateTime inicio, LocalDateTime fin) { return foroRepository.findByRangoFechas(inicio, fin); }

    public List<Foro> listarDesdeFecha(LocalDateTime fechaDesde) { return foroRepository.findDesdeFecha(fechaDesde); }

    public List<Foro> listarRecientes() { return foroRepository.findRecientes(); }

    public List<Foro> listarForosSeguidosPorUsuario(Integer idUsuario) { return foroRepository.findForosSeguidosPorUsuario(idUsuario); }
}
