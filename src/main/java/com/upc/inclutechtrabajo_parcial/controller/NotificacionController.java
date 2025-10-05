package com.upc.inclutechtrabajo_parcial.controller;

import com.upc.inclutechtrabajo_parcial.model.Notificacion;
import com.upc.inclutechtrabajo_parcial.service.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionController {
    @Autowired
    private NotificacionService notificacionService;

    @PostMapping
    public ResponseEntity<Notificacion> registrar(@RequestBody Notificacion notificacion) {
        return ResponseEntity.ok(notificacionService.registrar(notificacion));
    }

    @GetMapping
    public ResponseEntity<List<Notificacion>> listar() {
        return ResponseEntity.ok(notificacionService.listar());
    }
}
