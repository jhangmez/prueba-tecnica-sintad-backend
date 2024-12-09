package com.sintad_jhan.api.controller;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sintad_jhan.api.model.Entidad;
import com.sintad_jhan.api.service.EntidadService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@WebMvcTest(EntidadController.class)
public class EntidadControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EntidadService entidadService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllEntidades_shouldReturnListOfEntidades() throws Exception {
        List<Entidad> entidades = new ArrayList<>();
        // Crea algunas entidades de prueba
        when(entidadService.getAllEntidades()).thenReturn(entidades);

        mockMvc.perform(get("/entidades"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray());
    }

    @Test
void getEntidadById_shouldReturnEntidad() throws Exception {
    Long id = 1L;
    Entidad entidad = new Entidad(); // Crea una entidad de prueba
    entidad.setIdEntidad(id);
    when(entidadService.getEntidadById(id)).thenReturn(entidad);

    mockMvc.perform(get("/entidades/{id}", id))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.idEntidad").value(id));
}

@Test
void createEntidad_shouldCreateEntidad() throws Exception {

    Entidad entidadACrear = new Entidad();
    // Configura los datos de la entidad

    when(entidadService.createEntidad(entidadACrear)).thenReturn(entidadACrear);

    mockMvc.perform(post("/entidades")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(entidadACrear)))
            .andExpect(status().isCreated());

}



@Test
void updateEntidad_shouldUpdateEntidad() throws Exception {
    Long id = 1L;
    Entidad entidadActualizada = new Entidad();
    // Configura los datos de la entidad actualizada

    when(entidadService.updateEntidad(id, entidadActualizada)).thenReturn(entidadActualizada);

    mockMvc.perform(put("/entidades/{id}", id)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(entidadActualizada)))
            .andExpect(status().isOk());
}

@Test
void deleteEntidad_shouldDeleteEntidad() throws Exception {
    Long id = 1L;

    mockMvc.perform(delete("/entidades/{id}", id))
            .andExpect(status().isNoContent());
}
}
