package com.sintad_jhan.api.controller;

import com.sintad_jhan.api.model.Entidad;
import com.sintad_jhan.api.service.EntidadService;
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
@RequestMapping("/entidades")
public class EntidadController {
    @Autowired
    private EntidadService entidadService;

    @GetMapping
    public ResponseEntity<List<Entidad>> getAllEntidades() {
        List<Entidad> entidades = entidadService.getAllEntidades();
        return new ResponseEntity<>(entidades, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entidad> getEntidadById(@PathVariable Long id) {
        Entidad entidad = entidadService.getEntidadById(id);
        return new ResponseEntity<>(entidad, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Entidad> createEntidad(@Valid @RequestBody Entidad entidad) {
        Entidad createdEntidad = entidadService.createEntidad(entidad);
        return new ResponseEntity<>(createdEntidad, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entidad> updateEntidad(@PathVariable Long id, @Valid @RequestBody Entidad entidad) {
        Entidad updatedEntidad = entidadService.updateEntidad(id, entidad);
        return new ResponseEntity<>(updatedEntidad, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntidad(@PathVariable Long id) {
        entidadService.deleteEntidad(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
