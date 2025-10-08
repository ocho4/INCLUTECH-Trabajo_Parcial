package com.upc.inclutechtrabajo_parcial.service;

import com.upc.inclutechtrabajo_parcial.dto.CategoriaRecursoEducativoDTO;
import com.upc.inclutechtrabajo_parcial.model.CategoriaRecursoEducativo;
import com.upc.inclutechtrabajo_parcial.repository.CategoriaRecursoEducativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaRecursoEducativoService {
    @Autowired
    private CategoriaRecursoEducativoRepository categoriaRecursoRepository;

    public CategoriaRecursoEducativo registrar(CategoriaRecursoEducativo categoriaRecurso) {
        return categoriaRecursoRepository.save(categoriaRecurso);
    }

    public List<CategoriaRecursoEducativoDTO> listar() {
        return categoriaRecursoRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public CategoriaRecursoEducativoDTO actualizar(Integer id, CategoriaRecursoEducativoDTO dto) {
        CategoriaRecursoEducativo existente = categoriaRecursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría de recurso educativo con ID " + id + " no encontrada"));
        existente.setDescripcionRecurso(dto.getDescripcionRecurso());
        CategoriaRecursoEducativo actualizado = categoriaRecursoRepository.save(existente);
        return convertirADTO(actualizado);
    }

    public void eliminar(Integer id) {
        if (!categoriaRecursoRepository.existsById(id)) {
            throw new RuntimeException("Categoría con ID " + id + " no encontrada");
        }
        categoriaRecursoRepository.deleteById(id);
    }

    private CategoriaRecursoEducativoDTO convertirADTO(CategoriaRecursoEducativo categoriaRecurso) {
        return CategoriaRecursoEducativoDTO.builder()
                .id(categoriaRecurso.getId())
                .descripcionRecurso(categoriaRecurso.getDescripcionRecurso())
                .recursoId(categoriaRecurso.getRecursoEducativo() != null ? categoriaRecurso.getRecursoEducativo().getId() : null)
                .categoriaId(categoriaRecurso.getCategoria() != null ? categoriaRecurso.getCategoria().getId() : null)
                .build();
    }
}