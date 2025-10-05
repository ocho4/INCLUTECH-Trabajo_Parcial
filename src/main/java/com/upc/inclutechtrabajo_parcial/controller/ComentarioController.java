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

    @PostMapping("/registrar")
    public ResponseEntity<Comentario> registrar(@RequestBody Comentario comentario) {
        return ResponseEntity.ok(comentarioService.registrar(comentario));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Comentario>> listar() {
        return ResponseEntity.ok(comentarioService.listar());
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Comentario> actualizar(@PathVariable Integer id, @RequestBody Comentario comentario) {
        comentario.setId(id);
        return ResponseEntity.ok(comentarioService.registrar(comentario));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        comentarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

