package com.upc.inclutechtrabajo_parcial.service;

import com.upc.inclutechtrabajo_parcial.dto.RecursoEducativoDTO;
import com.upc.inclutechtrabajo_parcial.dto.RolDTO;
import com.upc.inclutechtrabajo_parcial.model.RecursoEducativo;
import com.upc.inclutechtrabajo_parcial.model.Rol;
import com.upc.inclutechtrabajo_parcial.repository.RecursoEducativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecursoEducativoService {
    @Autowired
    private RecursoEducativoRepository recursoRepository;

    public RecursoEducativo registrar(RecursoEducativo recurso) {
        return recursoRepository.save(recurso);
    }

    public List<RecursoEducativoDTO> listar() {
        return recursoRepository.findAll().stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public RecursoEducativo actualizar(Integer id, RecursoEducativo recursoActualizado) {
        RecursoEducativo recurso = recursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recurso educativo no encontrado con ID " + id));

        recurso.setTitulo(recursoActualizado.getTitulo());
        recurso.setDescripcion(recursoActualizado.getDescripcion());

        return recursoRepository.save(recurso);
    }

    public void eliminar(Integer id) {
        if (!recursoRepository.existsById(id)) {
            throw new RuntimeException("Recurso educativo con ID " + id + " no encontrado");
        }
        recursoRepository.deleteById(id);
    }

    private RecursoEducativoDTO convertirADTO(RecursoEducativo recursoEducativo) {
        RecursoEducativoDTO dto = new RecursoEducativoDTO();
        dto.setId(recursoEducativo.getId());
        dto.setTitulo(recursoEducativo.getTitulo());
        dto.setDescripcion(recursoEducativo.getDescripcion());
        return dto;
    }

}
