package com.upc.inclutechtrabajo_parcial.controller;

import com.upc.inclutechtrabajo_parcial.model.RecursoEducativoFavoritoUsuario;
import com.upc.inclutechtrabajo_parcial.service.RecursoEducativoFavoritoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favoritos")
public class RecursoEducativoFavoritoUsuarioController {
    @Autowired
    private RecursoEducativoFavoritoUsuarioService favoritoService;

    @PostMapping("/registrar")
    public ResponseEntity<RecursoEducativoFavoritoUsuario> registrar(@RequestBody RecursoEducativoFavoritoUsuario favorito) {
        return ResponseEntity.ok(favoritoService.registrar(favorito));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<RecursoEducativoFavoritoUsuario>> listar() {
        return ResponseEntity.ok(favoritoService.listar());
    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<RecursoEducativoFavoritoUsuario> actualizar(@PathVariable Integer id, @RequestBody RecursoEducativoFavoritoUsuario favorito) {
        favorito.setId(id);
        return ResponseEntity.ok(favoritoService.registrar(favorito));
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        favoritoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
