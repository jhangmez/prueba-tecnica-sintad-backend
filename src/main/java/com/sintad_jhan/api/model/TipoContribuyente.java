package com.sintad_jhan.api.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_tipo_contribuyente")
public class TipoContribuyente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_contribuyente")
    private Long idTipoContribuyente;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "estado", columnDefinition = "bit(1) default b'1'")
    private Boolean estado = true;
}
