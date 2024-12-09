package com.sintad_jhan.api.service;

import com.sintad_jhan.api.model.TipoContribuyente;

import java.util.List;

public interface TipoContribuyenteService {
    List<TipoContribuyente> getAllTiposContribuyente();
    TipoContribuyente getTipoContribuyenteById(Long id);
    TipoContribuyente createTipoContribuyente(TipoContribuyente tipo);
    TipoContribuyente updateTipoContribuyente(Long id, TipoContribuyente tipo);
    void deleteTipoContribuyente(Long id);
}
