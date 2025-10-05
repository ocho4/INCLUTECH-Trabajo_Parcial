package com.upc.inclutechtrabajo_parcial.service;

import com.upc.inclutechtrabajo_parcial.model.ForoQueSigueUsuario;
import com.upc.inclutechtrabajo_parcial.repository.ForoQueSigueUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForoQueSigueUsuarioService {
    @Autowired
    private ForoQueSigueUsuarioRepository foroQueSigueUsuarioRepository;

    public ForoQueSigueUsuario registrar(ForoQueSigueUsuario seguimiento) {
        return foroQueSigueUsuarioRepository.save(seguimiento);
    }

    public List<ForoQueSigueUsuario> listar() {
        return foroQueSigueUsuarioRepository.findAll();
    }
}
