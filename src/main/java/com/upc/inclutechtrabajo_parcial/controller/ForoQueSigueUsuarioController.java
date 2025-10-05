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

    @PostMapping
    public ResponseEntity<ForoQueSigueUsuario> registrar(@RequestBody ForoQueSigueUsuario seguimiento) {
        return ResponseEntity.ok(foroSeguidoService.registrar(seguimiento));
    }

    @GetMapping
    public ResponseEntity<List<ForoQueSigueUsuario>> listar() {
        return ResponseEntity.ok(foroSeguidoService.listar());
    }
}
