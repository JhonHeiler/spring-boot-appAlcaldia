package com.alcaldia.appAlcaldia.modelos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cargo", unique = true, nullable = false)
    @Getter @Setter
    private Integer id_cargo;
    @Getter @Setter
    private String cargo;

}
