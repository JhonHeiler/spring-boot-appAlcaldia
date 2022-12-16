package com.alcaldia.appAlcaldia.modelos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionario", unique = true, nullable = false)
    @Getter @Setter
    private Integer id_funcionario;
    @Getter @Setter
    private String ano;
    @Getter @Setter
    private Integer id_persona;
    @Getter @Setter
    private Integer id_cargo;

}
