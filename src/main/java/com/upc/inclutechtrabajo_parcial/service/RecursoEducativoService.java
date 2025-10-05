package com.upc.inclutechtrabajo_parcial.service;

import com.upc.inclutechtrabajo_parcial.model.RecursoEducativo;
import com.upc.inclutechtrabajo_parcial.repository.RecursoEducativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecursoEducativoService {
    @Autowired
    private RecursoEducativoRepository recursoRepository;

    public RecursoEducativo registrar(RecursoEducativo recurso) {
        return recursoRepository.save(recurso);
    }

    public List<RecursoEducativo> listar() {
        return recursoRepository.findAll();
    }
}
