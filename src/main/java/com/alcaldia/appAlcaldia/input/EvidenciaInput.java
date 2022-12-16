package com.alcaldia.appAlcaldia.input;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class EvidenciaInput {
    @Getter
    @Setter
    private String nombre;
    @Getter @Setter
    private String descripcion;
    @Getter @Setter
    private String imagen;
    @Getter @Setter
    private String ruta_almacenamiento;
    @Getter @Setter
    private Date fecha_cargue;
    @Getter @Setter
    private String estado;
    @Getter @Setter
    private Integer id_actividades_contrato;
    @Getter @Setter
    private Integer id_prueba;
    @Getter @Setter
    private Integer id_persona_carga;

}
