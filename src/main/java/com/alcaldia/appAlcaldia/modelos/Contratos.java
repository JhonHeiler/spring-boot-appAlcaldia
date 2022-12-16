package com.alcaldia.appAlcaldia.modelos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity

public class Contratos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contratos", unique = true, nullable = false)
    @Getter @Setter
    private Integer id_contratos;
    @Getter @Setter
    private String objeto;
    @Getter @Setter
    private String valor;
    @Getter @Setter
    private String secretaria;
    @Getter @Setter
    private Integer ano_de_contrato;
    @Getter @Setter
    private String cdp;
    @Getter @Setter
    private String rp;
    @Getter @Setter
    private Integer id_persona;

}
