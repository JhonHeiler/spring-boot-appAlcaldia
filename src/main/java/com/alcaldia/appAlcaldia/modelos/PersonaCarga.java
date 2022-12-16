package com.alcaldia.appAlcaldia.modelos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class PersonaCarga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona_carga", unique = true, nullable = false)
    @Getter @Setter
    private Integer id_persona_carga;
    @Getter @Setter
    private String carga;


}
