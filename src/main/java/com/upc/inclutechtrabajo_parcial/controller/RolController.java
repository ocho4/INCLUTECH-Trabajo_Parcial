package com.upc.inclutechtrabajo_parcial.controller;

import com.upc.inclutechtrabajo_parcial.model.Rol;
import com.upc.inclutechtrabajo_parcial.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolController {
    @Autowired
    private RolService rolService;

    @PostMapping
    public ResponseEntity<Rol> registrar(@RequestBody Rol rol) {
        return ResponseEntity.ok(rolService.registrar(rol));
    }

    @GetMapping
    public ResponseEntity<List<Rol>> listar() {
        return ResponseEntity.ok(rolService.listar());
    }
}