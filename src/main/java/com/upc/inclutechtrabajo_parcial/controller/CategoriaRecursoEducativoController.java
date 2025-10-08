package com.upc.inclutechtrabajo_parcial.controller;

import com.upc.inclutechtrabajo_parcial.dto.CategoriaRecursoEducativoDTO;
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

    @PostMapping("/registrar")
    public ResponseEntity<CategoriaRecursoEducativo> registrar(@RequestBody CategoriaRecursoEducativo categoriaRecurso) {
        return ResponseEntity.ok(categoriaRecursoService.registrar(categoriaRecurso));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<CategoriaRecursoEducativoDTO>> listar() {
        return ResponseEntity.ok(categoriaRecursoService.listar());
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<CategoriaRecursoEducativoDTO> actualizar(
            @PathVariable Integer id,
            @RequestBody CategoriaRecursoEducativoDTO categoriaRecursoDTO) {
        return ResponseEntity.ok(categoriaRecursoService.actualizar(id, categoriaRecursoDTO));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        categoriaRecursoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
