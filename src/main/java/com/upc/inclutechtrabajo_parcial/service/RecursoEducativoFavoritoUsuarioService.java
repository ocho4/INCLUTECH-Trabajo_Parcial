package com.upc.inclutechtrabajo_parcial.service;

import com.upc.inclutechtrabajo_parcial.dto.RecursoEducativoFavoritoUsuarioDTO;
import com.upc.inclutechtrabajo_parcial.model.RecursoEducativoFavoritoUsuario;
import com.upc.inclutechtrabajo_parcial.repository.RecursoEducativoFavoritoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecursoEducativoFavoritoUsuarioService {
    @Autowired
    private RecursoEducativoFavoritoUsuarioRepository favoritoRepository;

    public RecursoEducativoFavoritoUsuario registrar(RecursoEducativoFavoritoUsuario favorito) {
        return favoritoRepository.save(favorito);
    }

    public List<RecursoEducativoFavoritoUsuarioDTO> listar() {
        return favoritoRepository.findAll().stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public RecursoEducativoFavoritoUsuario actualizar(Integer id, RecursoEducativoFavoritoUsuario favoritoActualizado) {
        RecursoEducativoFavoritoUsuario favorito = favoritoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recurso favorito no encontrado con ID " + id));
        favorito.setFechaAgregado(favoritoActualizado.getFechaAgregado());
        favorito.setUsuario(favoritoActualizado.getUsuario());
        favorito.setRecurso(favoritoActualizado.getRecurso());
        return favoritoRepository.save(favorito);
    }

    public void eliminar(Integer id) {
        if (!favoritoRepository.existsById(id)) {
            throw new RuntimeException("Recurso favorito con ID " + id + " no encontrado");
        }
        favoritoRepository.deleteById(id);
    }

    private RecursoEducativoFavoritoUsuarioDTO convertirADTO(RecursoEducativoFavoritoUsuario favorito) {
        return RecursoEducativoFavoritoUsuarioDTO.builder()
                .id(favorito.getId())
                .fechaAgregado(favorito.getFechaAgregado())
                .usuarioId(favorito.getUsuario() != null ? favorito.getUsuario().getId() : null)
                .recursoId(favorito.getRecurso() != null ? favorito.getRecurso().getId() : null)
                .build();
    }

}
