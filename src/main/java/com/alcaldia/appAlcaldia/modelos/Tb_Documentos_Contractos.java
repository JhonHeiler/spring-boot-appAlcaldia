package com.alcaldia.appAlcaldia.modelos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Tb_Documentos_Contractos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tb_documentos_contractos", unique = true, nullable = false)
    @Getter @Setter
    private Integer id_tb_documentos_contractos;
    @Getter @Setter
    private Date fecha_cargue;
    @Getter @Setter
    private String archivo_ruta;
    @Getter @Setter
    private Integer id_categoria;
    @Getter @Setter
    private Integer id_persona;
}
