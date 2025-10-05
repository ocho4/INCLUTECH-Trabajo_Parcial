package com.upc.inclutechtrabajo_parcial.service;

import com.upc.inclutechtrabajo_parcial.model.PublicacionForo;
import com.upc.inclutechtrabajo_parcial.repository.PublicacionForoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicacionForoService {
    @Autowired
    private PublicacionForoRepository publicacionRepository;

    public PublicacionForo registrar(PublicacionForo publicacion) {
        return publicacionRepository.save(publicacion);
    }

    public List<PublicacionForo> listar() {
        return publicacionRepository.findAll();
    }

    public void eliminar(Integer id) {
        if (!publicacionRepository.existsById(id)) {
            throw new RuntimeException("Publicación con ID " + id + " no encontrada");
        }
        publicacionRepository.deleteById(id);
    }

}
