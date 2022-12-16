package com.alcaldia.appAlcaldia.modelos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Secretaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_secretaria", unique = true, nullable = false)
    @Getter @Setter
    private Integer id_secretaria;
    @Getter @Setter
    private  String nombre;
    @Getter @Setter
    private Integer id_contratos;


}
