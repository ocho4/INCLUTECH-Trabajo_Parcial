package com.upc.inclutechtrabajo_parcial.controller;

import com.upc.inclutechtrabajo_parcial.dto.UsuarioDTO;
import com.upc.inclutechtrabajo_parcial.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrar")
    public ResponseEntity<UsuarioDTO> registrar(@RequestBody UsuarioDTO dto) {
        return ResponseEntity.ok(usuarioService.registrar(dto));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioDTO>> listar() {
        return ResponseEntity.ok(usuarioService.listar());
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<UsuarioDTO> actualizar(@PathVariable Integer id, @RequestBody UsuarioDTO dto) {
        dto.setId(id);
        return ResponseEntity.ok(usuarioService.actualizar(id, dto));
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        usuarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filtrar")
    public ResponseEntity<List<UsuarioDTO>> filtrarPorRol(@RequestParam String rol) {
        return ResponseEntity.ok(usuarioService.filtrarPorRol(rol));
    }
    @GetMapping("/favoritos")
    public ResponseEntity<List<UsuarioDTO>> listarUsuariosConFavoritos() {
        return ResponseEntity.ok(usuarioService.listarConFavoritos());
    }
    @GetMapping("/siguiendo-foros")
    public ResponseEntity<List<UsuarioDTO>> listarUsuariosQueSiguenForos() {
        return ResponseEntity.ok(usuarioService.listarUsuariosQueSiguenForos());
    }
}