package com.upc.inclutechtrabajo_parcial.service;

import com.upc.inclutechtrabajo_parcial.model.CategoriaRecursoEducativo;
import com.upc.inclutechtrabajo_parcial.repository.CategoriaRecursoEducativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaRecursoEducativoService {
    @Autowired
    private CategoriaRecursoEducativoRepository categoriaRecursoRepository;

    public CategoriaRecursoEducativo registrar(CategoriaRecursoEducativo categoriaRecurso) {
        return categoriaRecursoRepository.save(categoriaRecurso);
    }

    public List<CategoriaRecursoEducativo> listar() {
        return categoriaRecursoRepository.findAll();
    }
}
