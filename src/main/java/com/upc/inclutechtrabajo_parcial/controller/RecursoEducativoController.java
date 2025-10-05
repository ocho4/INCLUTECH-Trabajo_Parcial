package com.upc.inclutechtrabajo_parcial.controller;

import com.upc.inclutechtrabajo_parcial.model.RecursoEducativo;
import com.upc.inclutechtrabajo_parcial.service.RecursoEducativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recursos")
public class RecursoEducativoController {
    @Autowired
    private RecursoEducativoService recursoService;

    @PostMapping("/registrar")
    public ResponseEntity<RecursoEducativo> registrar(@RequestBody RecursoEducativo recurso) {
        return ResponseEntity.ok(recursoService.registrar(recurso));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<RecursoEducativo>> listar() {
        return ResponseEntity.ok(recursoService.listar());
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<RecursoEducativo> actualizar(@PathVariable Integer id, @RequestBody RecursoEducativo recurso) {
        recurso.setId(id);
        return ResponseEntity.ok(recursoService.registrar(recurso));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        recursoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
