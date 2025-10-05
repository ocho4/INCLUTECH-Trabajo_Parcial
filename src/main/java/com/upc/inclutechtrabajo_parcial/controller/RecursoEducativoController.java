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

    @PostMapping
    public ResponseEntity<RecursoEducativo> registrar(@RequestBody RecursoEducativo recurso) {
        return ResponseEntity.ok(recursoService.registrar(recurso));
    }

    @GetMapping
    public ResponseEntity<List<RecursoEducativo>> listar() {
        return ResponseEntity.ok(recursoService.listar());
    }

}
