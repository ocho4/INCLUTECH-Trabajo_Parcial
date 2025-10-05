package com.upc.inclutechtrabajo_parcial.controller;

import com.upc.inclutechtrabajo_parcial.model.CategoriaRecursoEducativo;
import com.upc.inclutechtrabajo_parcial.service.CategoriaRecursoEducativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria-recursos")
public class CategoriaRecursoEducativoController {
    @Autowired
    private CategoriaRecursoEducativoService categoriaRecursoService;

    @PostMapping
    public ResponseEntity<CategoriaRecursoEducativo> registrar(@RequestBody CategoriaRecursoEducativo categoriaRecurso) {
        return ResponseEntity.ok(categoriaRecursoService.registrar(categoriaRecurso));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaRecursoEducativo>> listar() {
        return ResponseEntity.ok(categoriaRecursoService.listar());
    }
}
