package com.alcaldia.appAlcaldia.modelos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Oficina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_oficina", unique = true, nullable = false)
    @Getter @Setter
    private Integer id_oficina;
    @Getter @Setter
    private String nombre;
    @Getter @Setter
    private Integer id_secretaria;

}
