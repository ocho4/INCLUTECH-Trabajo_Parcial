package com.upc.inclutechtrabajo_parcial.service;

import com.upc.inclutechtrabajo_parcial.model.Foro;
import com.upc.inclutechtrabajo_parcial.repository.ForoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public List<Foro> listarPorUsuario(Integer idUsuario) { return foroRepository.findByUsuario_Id(idUsuario); }

    public List<Foro> listarPorCategoria(Integer idCategoria) { return foroRepository.findByCategoriaId(idCategoria); }

    public List<Foro> listarPorFechas(LocalDateTime inicio, LocalDateTime fin) { return foroRepository.findByRangoFechas(inicio, fin); }

    public List<Foro> listarDesdeFecha(LocalDateTime fechaDesde) { return foroRepository.findDesdeFecha(fechaDesde); }

    public List<Foro> listarRecientes() { return foroRepository.findRecientes(); }

    public List<Foro> listarForosSeguidosPorUsuario(Integer idUsuario) { return foroRepository.findForosSeguidosPorUsuario(idUsuario); }
}
