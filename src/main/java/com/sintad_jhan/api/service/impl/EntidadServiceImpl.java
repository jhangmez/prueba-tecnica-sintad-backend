package com.sintad_jhan.api.service.impl;

import com.sintad_jhan.api.exception.EntityNotFoundException;
import com.sintad_jhan.api.exception.InvalidDataException;
import com.sintad_jhan.api.model.Entidad;
import com.sintad_jhan.api.repository.EntidadRepository;
import com.sintad_jhan.api.service.EntidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntidadServiceImpl implements EntidadService {
    @Autowired
    private EntidadRepository entidadRepository;

    @Override
    public List<Entidad> getAllEntidades() {
        return entidadRepository.findAll();
    }

    @Override
    public Entidad getEntidadById(Long id) {
        return entidadRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entidad no encontrada con ID: " + id));
    }

    @Override
    public Entidad createEntidad(Entidad entidad) {
        if (entidad.getIdEntidad() != null) {
            throw new InvalidDataException("El ID de la entidad debe ser nulo para la creación");
        }
        return entidadRepository.save(entidad);
    }

    @Override
    public Entidad updateEntidad(Long id, Entidad entidadActualizada) {
        if (!entidadRepository.existsById(id)) {
            throw new EntityNotFoundException("Entidad no encontrada con ID: " + id);
        }
        entidadActualizada.setIdEntidad(id);
        return entidadRepository.save(entidadActualizada);
    }

    @Override
    public void deleteEntidad(Long id) {
        if (!entidadRepository.existsById(id)) {
            throw new EntityNotFoundException("Entidad no encontrada con ID: " + id);
        }
        entidadRepository.deleteById(id);
    }
}
