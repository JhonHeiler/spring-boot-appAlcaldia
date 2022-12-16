package com.alcaldia.appAlcaldia.modelos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity

public class TipoDocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_documento", unique = true, nullable = false)
    @Getter @Setter
    private Integer id_tipo_documento;
    @Getter @Setter
    private String tipo_documento;


}
