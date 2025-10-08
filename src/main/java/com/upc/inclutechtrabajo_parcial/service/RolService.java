package com.upc.inclutechtrabajo_parcial.service;

import com.upc.inclutechtrabajo_parcial.dto.RolDTO;
import com.upc.inclutechtrabajo_parcial.dto.UsuarioDTO;
import com.upc.inclutechtrabajo_parcial.model.Rol;
import com.upc.inclutechtrabajo_parcial.model.Usuario;
import com.upc.inclutechtrabajo_parcial.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;

    public Rol registrar(Rol rol) {
        return rolRepository.save(rol);
    }

    public List<RolDTO> listar() {
        return rolRepository.findAll().stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public void eliminar(Integer id) {
        if (!rolRepository.existsById(id)) {
            throw new RuntimeException("Rol con ID " + id + " no encontrado");
        }
        rolRepository.deleteById(id);
    }

    public Rol actualizar(Integer id, Rol rol) {
        Rol existente = rolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol con ID " + id + " no encontrado"));

        existente.setNombre(rol.getNombre());
        existente.setDescripcion(rol.getDescripcion());

        return rolRepository.save(existente);
    }


    private RolDTO convertirADTO(Rol rol) {
        RolDTO dto = new RolDTO();
        dto.setId(rol.getId());
        dto.setNombre(rol.getNombre());
        dto.setDescripcion(rol.getDescripcion());
        return dto;
    }

}
