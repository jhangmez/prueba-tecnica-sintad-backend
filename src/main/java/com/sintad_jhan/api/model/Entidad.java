package com.sintad_jhan.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_entidad")
public class Entidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entidad")
    private Long idEntidad;

    @ManyToOne
    @JoinColumn(name = "id_tipo_documento", nullable = false)
    private TipoDocumento tipoDocumento;

    @Column(name = "nro_documento", length = 25, unique = true, nullable = false)
    private String nroDocumento;

    @Column(name = "razon_social", length = 100, nullable = false)
    private String razonSocial;

    @Column(name = "nombre_comercial", length = 100)
    private String nombreComercial;

    @ManyToOne
    @JoinColumn(name = "id_tipo_contribuyente")
    private TipoContribuyente tipoContribuyente;

    @Column(name = "direccion", length = 250)
    private String direccion;

    @Column(name = "telefono", length = 50)
    private String telefono;

    @Column(name = "estado", columnDefinition = "bit(1) default b'1'")
    private Boolean estado = true;
}
