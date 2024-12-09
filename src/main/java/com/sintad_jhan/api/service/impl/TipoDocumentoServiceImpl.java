package com.sintad_jhan.api.service.impl;

import com.sintad_jhan.api.exception.EntityNotFoundException;
import com.sintad_jhan.api.exception.InvalidDataException;
import com.sintad_jhan.api.model.TipoDocumento;
import com.sintad_jhan.api.repository.TipoDocumentoRepository;
import com.sintad_jhan.api.service.TipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {
    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Override
    public List<TipoDocumento> getAllTiposDocumento() {
        return tipoDocumentoRepository.findAll();
    }

    @Override
    public TipoDocumento getTipoDocumentoById(Long id) {
        return tipoDocumentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tipo de documento no encontrado con ID: " + id));
    }

    @Override
    public TipoDocumento createTipoDocumento(TipoDocumento tipo) {
        if (tipo.getIdTipoDocumento() != null) {
            throw new InvalidDataException("El ID del tipo de documento debe ser nulo para la creación");
        }
        return tipoDocumentoRepository.save(tipo);
    }

    @Override
    public TipoDocumento updateTipoDocumento(Long id, TipoDocumento tipoActualizado) {
        if (!tipoDocumentoRepository.existsById(id)) {
            throw new EntityNotFoundException("Tipo de documento no encontrado con ID: " + id);
        }
        tipoActualizado.setIdTipoDocumento(id);
        return tipoDocumentoRepository.save(tipoActualizado);
    }

    @Override
    public void deleteTipoDocumento(Long id) {
        if (!tipoDocumentoRepository.existsById(id)) {
            throw new EntityNotFoundException("Tipo de documento no encontrado con ID: " + id);
        }
        tipoDocumentoRepository.deleteById(id);
    }
}
