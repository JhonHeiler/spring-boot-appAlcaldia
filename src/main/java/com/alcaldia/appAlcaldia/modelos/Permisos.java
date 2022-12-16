package com.alcaldia.appAlcaldia.modelos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Permisos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permisos", unique = true, nullable = false)
    @Getter @Setter
    private Integer id_permisos	;
    @Getter @Setter
    private Integer id_rol	;
    @Getter @Setter
    private String url;
    @Getter @Setter
    private Integer create;
    @Getter @Setter
    private Integer read;
    @Getter @Setter
    private Integer update;
    @Getter @Setter
    private Integer delete;

    public Permisos() {
    }
}
