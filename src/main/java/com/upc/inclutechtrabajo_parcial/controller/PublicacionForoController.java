package com.upc.inclutechtrabajo_parcial.controller;

import com.upc.inclutechtrabajo_parcial.dto.PublicacionForoDTO;
import com.upc.inclutechtrabajo_parcial.model.PublicacionForo;
import com.upc.inclutechtrabajo_parcial.service.PublicacionForoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publicaciones")
public class PublicacionForoController {
    @Autowired
    private PublicacionForoService publicacionService;

    @PostMapping("/registrar")
    public ResponseEntity<PublicacionForo> registrar(@RequestBody PublicacionForo publicacion) {
        return ResponseEntity.ok(publicacionService.registrar(publicacion));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<PublicacionForo>> listar() {
        return ResponseEntity.ok(publicacionService.listar());
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<PublicacionForo> actualizar(@PathVariable Integer id, @RequestBody PublicacionForo publicacion) {
        publicacion.setId(id);
        return ResponseEntity.ok(publicacionService.registrar(publicacion));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        publicacionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filtrar/usuario")
    public ResponseEntity<List<PublicacionForoDTO>> filtrarPorUsuario(@RequestParam Long idUsuario) {
        return ResponseEntity.ok(publicacionService.filtrarPorUsuario(idUsuario));
    }

    @GetMapping("/filtrar/foro")
    public ResponseEntity<List<PublicacionForoDTO>> filtrarPorForo(@RequestParam Long idForo) {
        return ResponseEntity.ok(publicacionService.filtrarPorForo(idForo));
    }

    @GetMapping("/buscar/titulo")
    public ResponseEntity<List<PublicacionForoDTO>> buscarPorTitulo(@RequestParam String palabra) {
        return ResponseEntity.ok(publicacionService.buscarPorTitulo(palabra));
    }

}
