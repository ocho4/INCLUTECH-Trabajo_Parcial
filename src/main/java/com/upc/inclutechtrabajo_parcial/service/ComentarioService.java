package com.upc.inclutechtrabajo_parcial.service;

import com.upc.inclutechtrabajo_parcial.model.Comentario;
import com.upc.inclutechtrabajo_parcial.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {
    @Autowired
    private ComentarioRepository comentarioRepository;

    public Comentario registrar(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public List<Comentario> listar() {
        return comentarioRepository.findAll();
    }
}
