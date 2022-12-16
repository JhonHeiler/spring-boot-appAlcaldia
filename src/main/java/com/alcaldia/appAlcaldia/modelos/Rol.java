package com.alcaldia.appAlcaldia.modelos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol", unique = true, nullable = false)
    @Getter @Setter
    private Integer id_rol;
    @Getter @Setter
    private String nombre;


}
