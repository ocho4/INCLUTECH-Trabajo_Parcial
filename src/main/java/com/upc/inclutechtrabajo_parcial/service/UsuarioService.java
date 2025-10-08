package com.upc.inclutechtrabajo_parcial.service;

import com.upc.inclutechtrabajo_parcial.dto.UsuarioDTO;
import com.upc.inclutechtrabajo_parcial.model.Usuario;
import com.upc.inclutechtrabajo_parcial.repository.RolRepository;
import com.upc.inclutechtrabajo_parcial.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; //

    public UsuarioDTO registrar(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setUsername(dto.getUsername());
        usuario.setEmail(dto.getEmail());
        usuario.setContrasena(passwordEncoder.encode(dto.getContrasena())); // ENCRIPTAR

        if (dto.getRolId() != null) {
            rolRepository.findById(dto.getRolId()).ifPresent(usuario::setRol);
        }

        return convertirADTO(usuarioRepository.save(usuario));
    }

    public List<UsuarioDTO> listar() {
        return usuarioRepository.findAll().stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public UsuarioDTO actualizar(Integer id, UsuarioDTO dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID " + id));

        usuario.setNombre(dto.getNombre());
        usuario.setUsername(dto.getUsername());
        usuario.setEmail(dto.getEmail());
        if (dto.getContrasena() != null && !dto.getContrasena().isBlank()) {
            usuario.setContrasena(passwordEncoder.encode(dto.getContrasena()));
        }
        if (dto.getRolId() != null) {
            rolRepository.findById(dto.getRolId()).ifPresent(usuario::setRol);
        }

        return convertirADTO(usuarioRepository.save(usuario));
    }


    public void eliminar(Integer id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuario con ID " + id + " no encontrado");
        }
        usuarioRepository.deleteById(id);
    }

    private UsuarioDTO convertirADTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNombre(usuario.getNombre());
        dto.setUsername(usuario.getUsername());
        dto.setEmail(usuario.getEmail());
        dto.setContrasena(usuario.getContrasena()); //
        dto.setRolId(usuario.getRol() != null ? usuario.getRol().getId() : null);
        return dto;
    }

    public List<UsuarioDTO> filtrarPorRol(String rol) {
        return usuarioRepository.findByRolNombreIgnoreCase(rol)
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }
    public List<UsuarioDTO> listarConFavoritos() {
        return usuarioRepository.findUsuariosConFavoritos()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }
}
