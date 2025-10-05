package com.upc.inclutechtrabajo_parcial.service;

import com.upc.inclutechtrabajo_parcial.model.Categoria;
import com.upc.inclutechtrabajo_parcial.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria registrar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    public void eliminar(Integer id) {
        if (!categoriaRepository.existsById(id)) {
            throw new RuntimeException("Categoría con ID " + id + " no encontrada");
        }
        categoriaRepository.deleteById(id);
    }
}
