package com.upc.inclutechtrabajo_parcial.controller;

import com.upc.inclutechtrabajo_parcial.model.ForoQueSigueUsuario;
import com.upc.inclutechtrabajo_parcial.service.ForoQueSigueUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foros-seguidos")
public class ForoQueSigueUsuarioController {
    @Autowired
    private ForoQueSigueUsuarioService foroSeguidoService;

    @PostMapping("/registrar")
    public ResponseEntity<ForoQueSigueUsuario> registrar(@RequestBody ForoQueSigueUsuario seguimiento) {
        return ResponseEntity.ok(foroSeguidoService.registrar(seguimiento));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ForoQueSigueUsuario>> listar() {
        return ResponseEntity.ok(foroSeguidoService.listar());
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ForoQueSigueUsuario> actualizar(@PathVariable Integer id, @RequestBody ForoQueSigueUsuario seguimiento) {
        seguimiento.setId(id);
        return ResponseEntity.ok(foroSeguidoService.registrar(seguimiento));
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        foroSeguidoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
