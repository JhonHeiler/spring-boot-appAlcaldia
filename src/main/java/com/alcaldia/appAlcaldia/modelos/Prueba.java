package com.alcaldia.appAlcaldia.modelos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Prueba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prueba", unique = true, nullable = false)
    @Getter @Setter
    private Integer id_prueba;
    @Getter @Setter
    private String prueba;



}
