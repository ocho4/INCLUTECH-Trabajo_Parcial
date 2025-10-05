package com.upc.inclutechtrabajo_parcial.service;

import com.upc.inclutechtrabajo_parcial.model.Rol;
import com.upc.inclutechtrabajo_parcial.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;

    public Rol registrar(Rol rol) {
        return rolRepository.save(rol);
    }

    public List<Rol> listar() {
        return rolRepository.findAll();
    }
}
