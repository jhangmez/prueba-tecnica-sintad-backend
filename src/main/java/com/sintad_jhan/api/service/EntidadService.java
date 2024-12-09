package com.sintad_jhan.api.service;

import com.sintad_jhan.api.model.Entidad;

import java.util.List;

public interface  EntidadService {
    List<Entidad> getAllEntidades();
    Entidad getEntidadById(Long id);
    Entidad createEntidad(Entidad entidad);
    Entidad updateEntidad(Long id, Entidad entidad);
    void deleteEntidad(Long id);
}
