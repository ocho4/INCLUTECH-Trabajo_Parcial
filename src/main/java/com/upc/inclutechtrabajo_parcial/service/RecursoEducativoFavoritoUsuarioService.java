package com.upc.inclutechtrabajo_parcial.service;

import com.upc.inclutechtrabajo_parcial.model.RecursoEducativoFavoritoUsuario;
import com.upc.inclutechtrabajo_parcial.repository.RecursoEducativoFavoritoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecursoEducativoFavoritoUsuarioService {
    @Autowired
    private RecursoEducativoFavoritoUsuarioRepository favoritoRepository;

    public RecursoEducativoFavoritoUsuario registrar(RecursoEducativoFavoritoUsuario favorito) {
        return favoritoRepository.save(favorito);
    }

    public List<RecursoEducativoFavoritoUsuario> listar() {
        return favoritoRepository.findAll();
    }
}
