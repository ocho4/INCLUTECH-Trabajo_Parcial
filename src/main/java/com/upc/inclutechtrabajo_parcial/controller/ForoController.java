package com.upc.inclutechtrabajo_parcial.controller;

import com.upc.inclutechtrabajo_parcial.model.Foro;
import com.upc.inclutechtrabajo_parcial.service.ForoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/foros")
public class ForoController {
    @Autowired
    private ForoService foroService;

    @PostMapping
    public ResponseEntity<Foro> registrar(@RequestBody Foro foro) {
        return ResponseEntity.ok(foroService.registrar(foro));
    }

    @GetMapping
    public ResponseEntity<List<Foro>> listar() {
        return ResponseEntity.ok(foroService.listar());
    }
    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<Foro>> listarPorUsuario(@PathVariable Integer idUsuario) {
        return ResponseEntity.ok(foroService.listarPorUsuario(idUsuario));
    }

    @GetMapping("/categoria/{idCategoria}")
    public ResponseEntity<List<Foro>> listarPorCategoria(@PathVariable Integer idCategoria) {
        return ResponseEntity.ok(foroService.listarPorCategoria(idCategoria));
    }

    @GetMapping("/fechas")
    public ResponseEntity<List<Foro>> listarPorFechas(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fin) {
        return ResponseEntity.ok(foroService.listarPorFechas(inicio, fin));
    }

    @GetMapping("/desde")
    public ResponseEntity<List<Foro>> listarDesdeFecha(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaDesde) {
        return ResponseEntity.ok(foroService.listarDesdeFecha(fechaDesde));
    }

    @GetMapping("/recientes")
    public ResponseEntity<List<Foro>> listarRecientes() {
        return ResponseEntity.ok(foroService.listarRecientes());
    }

    @GetMapping("/seguidos/{idUsuario}")
    public ResponseEntity<List<Foro>> listarForosSeguidos(@PathVariable Integer idUsuario) {
        return ResponseEntity.ok(foroService.listarForosSeguidosPorUsuario(idUsuario));
    }
}
