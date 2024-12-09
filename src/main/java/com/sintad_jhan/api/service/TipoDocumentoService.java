package com.sintad_jhan.api.service;

import com.sintad_jhan.api.model.TipoDocumento;

import java.util.List;

public interface TipoDocumentoService {
    List<TipoDocumento> getAllTiposDocumento();
    TipoDocumento getTipoDocumentoById(Long id);
    TipoDocumento createTipoDocumento(TipoDocumento tipo);
    TipoDocumento updateTipoDocumento(Long id, TipoDocumento tipo);
    void deleteTipoDocumento(Long id);
}
