package com.upc.inclutechtrabajo_parcial.service;

import com.upc.inclutechtrabajo_parcial.model.Foro;
import com.upc.inclutechtrabajo_parcial.repository.ForoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForoService {
    @Autowired
    private ForoRepository foroRepository;

    public Foro registrar(Foro foro) {
        return foroRepository.save(foro);
    }

    public List<Foro> listar() {
        return foroRepository.findAll();
    }

    public void eliminar(Integer id) {
        if (!foroRepository.existsById(id)) {
            throw new RuntimeException("Foro con ID " + id + " no encontrado");
        }
        foroRepository.deleteById(id);
    }

}
