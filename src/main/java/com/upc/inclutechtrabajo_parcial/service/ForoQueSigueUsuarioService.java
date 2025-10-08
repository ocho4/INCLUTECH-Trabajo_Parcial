package com.upc.inclutechtrabajo_parcial.service;

import com.upc.inclutechtrabajo_parcial.dto.ForoQueSigueUsuarioDTO;
import com.upc.inclutechtrabajo_parcial.model.ForoQueSigueUsuario;
import com.upc.inclutechtrabajo_parcial.repository.ForoQueSigueUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ForoQueSigueUsuarioService {
    @Autowired
    private ForoQueSigueUsuarioRepository foroQueSigueUsuarioRepository;

    public ForoQueSigueUsuario registrar(ForoQueSigueUsuario seguimiento) {
        return foroQueSigueUsuarioRepository.save(seguimiento);
    }

    public List<ForoQueSigueUsuarioDTO> listar() {
        return foroQueSigueUsuarioRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public void eliminar(Integer id) {
        if (!foroQueSigueUsuarioRepository.existsById(id)) {
            throw new RuntimeException("Registro de seguimiento con ID " + id + " no encontrado");
        }
        foroQueSigueUsuarioRepository.deleteById(id);
    }

    public ForoQueSigueUsuario actualizar(Integer id, ForoQueSigueUsuario seguimientoActualizado) {
        ForoQueSigueUsuario seguimientoExistente = foroQueSigueUsuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seguimiento con ID " + id + " no encontrado"));

        seguimientoExistente.setFechaSeguimiento(seguimientoActualizado.getFechaSeguimiento());
        seguimientoExistente.setUsuario(seguimientoActualizado.getUsuario());
        seguimientoExistente.setForo(seguimientoActualizado.getForo());

        return foroQueSigueUsuarioRepository.save(seguimientoExistente);
    }

    private ForoQueSigueUsuarioDTO convertirADTO(ForoQueSigueUsuario f) {
        ForoQueSigueUsuarioDTO dto = new ForoQueSigueUsuarioDTO();
        dto.setId(f.getId());
        dto.setFechaSeguimiento(f.getFechaSeguimiento());

        if (f.getUsuario() != null) {
            dto.setUsuarioId(f.getUsuario().getId());
        }
        if (f.getForo() != null) {
            dto.setForoId(f.getForo().getId());
        }

        return dto;
    }


}
