package com.sintad_jhan.api.controller;

import com.sintad_jhan.api.model.TipoContribuyente;
import com.sintad_jhan.api.service.TipoContribuyenteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@RestController
@RequestMapping("/tipos-contribuyente")
public class TipoContribuyenteController {
    @Autowired
    private TipoContribuyenteService tipoContribuyenteService;

    @GetMapping
    public ResponseEntity<List<TipoContribuyente>> getAllTiposContribuyente() {
        List<TipoContribuyente> tipos = tipoContribuyenteService.getAllTiposContribuyente();
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoContribuyente> getTipoContribuyenteById(@PathVariable Long id) {
        TipoContribuyente tipo = tipoContribuyenteService.getTipoContribuyenteById(id);
        return new ResponseEntity<>(tipo, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TipoContribuyente> createTipoContribuyente(@Valid @RequestBody TipoContribuyente tipo) {
        TipoContribuyente createdTipo = tipoContribuyenteService.createTipoContribuyente(tipo);
        return new ResponseEntity<>(createdTipo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoContribuyente> updateTipoContribuyente(@PathVariable Long id, @Valid @RequestBody TipoContribuyente tipo) {
        TipoContribuyente updatedTipo = tipoContribuyenteService.updateTipoContribuyente(id, tipo);
        return new ResponseEntity<>(updatedTipo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoContribuyente(@PathVariable Long id) {
        tipoContribuyenteService.deleteTipoContribuyente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
