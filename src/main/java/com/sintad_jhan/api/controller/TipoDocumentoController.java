package com.sintad_jhan.api.controller;
import com.sintad_jhan.api.model.TipoDocumento;
import com.sintad_jhan.api.service.TipoDocumentoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/tipos-documento")
public class TipoDocumentoController {
    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @GetMapping
    public ResponseEntity<List<TipoDocumento>> getAllTiposDocumento() {
        List<TipoDocumento> tipos = tipoDocumentoService.getAllTiposDocumento();
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoDocumento> getTipoDocumentoById(@PathVariable Long id) {
        TipoDocumento tipo = tipoDocumentoService.getTipoDocumentoById(id);
        return new ResponseEntity<>(tipo, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TipoDocumento> createTipoDocumento(@Valid @RequestBody TipoDocumento tipo) {
        TipoDocumento createdTipo = tipoDocumentoService.createTipoDocumento(tipo);
        return new ResponseEntity<>(createdTipo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoDocumento> updateTipoDocumento(@PathVariable Long id, @Valid @RequestBody TipoDocumento tipo) {
        TipoDocumento updatedTipo = tipoDocumentoService.updateTipoDocumento(id, tipo);
        return new ResponseEntity<>(updatedTipo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoDocumento(@PathVariable Long id) {
        tipoDocumentoService.deleteTipoDocumento(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
