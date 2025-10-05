package com.upc.inclutechtrabajo_parcial.controller;

import com.upc.inclutechtrabajo_parcial.model.Comentario;
import com.upc.inclutechtrabajo_parcial.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {
    @Autowired
    private ComentarioService comentarioService;

    @PostMapping
    public ResponseEntity<Comentario> registrar(@RequestBody Comentario comentario) {
        return ResponseEntity.ok(comentarioService.registrar(comentario));
    }

    @GetMapping
    public ResponseEntity<List<Comentario>> listar() {
        return ResponseEntity.ok(comentarioService.listar());
    }
}

