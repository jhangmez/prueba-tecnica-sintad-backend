package com.sintad_jhan.api.service.impl;

import com.sintad_jhan.api.exception.EntityNotFoundException;
import com.sintad_jhan.api.exception.InvalidDataException;
import com.sintad_jhan.api.model.TipoContribuyente;
import com.sintad_jhan.api.repository.TipoContribuyenteRepository;
import com.sintad_jhan.api.service.TipoContribuyenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoContribuyenteServiceImpl implements TipoContribuyenteService {
    @Autowired
    private TipoContribuyenteRepository tipoContribuyenteRepository;

    @Override
    public List<TipoContribuyente> getAllTiposContribuyente() {
        return tipoContribuyenteRepository.findAll();
    }

    @Override
    public TipoContribuyente getTipoContribuyenteById(Long id) {
        return tipoContribuyenteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tipo de contribuyente no encontrado con ID: " + id));
    }

    @Override
    public TipoContribuyente createTipoContribuyente(TipoContribuyente tipo) {
        if (tipo.getIdTipoContribuyente() != null) {
            throw new InvalidDataException("El ID del tipo de contribuyente debe ser nulo para la creación");
        }
        return tipoContribuyenteRepository.save(tipo);
    }

    @Override
    public TipoContribuyente updateTipoContribuyente(Long id, TipoContribuyente tipoActualizado) {
        if (!tipoContribuyenteRepository.existsById(id)) {
            throw new EntityNotFoundException("Tipo de contribuyente no encontrado con ID: " + id);
        }
        tipoActualizado.setIdTipoContribuyente(id);
        return tipoContribuyenteRepository.save(tipoActualizado);
    }

    @Override
    public void deleteTipoContribuyente(Long id) {
        if (!tipoContribuyenteRepository.existsById(id)) {
            throw new EntityNotFoundException("Tipo de contribuyente no encontrado con ID: " + id);
        }
        tipoContribuyenteRepository.deleteById(id);
    }
}
