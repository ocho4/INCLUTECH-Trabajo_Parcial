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

    @PostMapping
    public ResponseEntity<RecursoEducativoFavoritoUsuario> registrar(@RequestBody RecursoEducativoFavoritoUsuario favorito) {
        return ResponseEntity.ok(favoritoService.registrar(favorito));
    }

    @GetMapping
    public ResponseEntity<List<RecursoEducativoFavoritoUsuario>> listar() {
        return ResponseEntity.ok(favoritoService.listar());
    }
}
