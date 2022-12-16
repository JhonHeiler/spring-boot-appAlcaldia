package com.alcaldia.appAlcaldia.modelos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona", unique = true, nullable = false)
    @Getter @Setter
    private Integer id_persona;
    @Getter @Setter
    private Integer documento;
    @Getter @Setter
    private String nombre;
    @Getter @Setter
    private String apellido;
    @Getter @Setter
    private String sexo;
    @Getter @Setter
    private String telefono;
    @Getter @Setter
    private String correo;
    @Getter @Setter
    private Integer id_cargo;
    @Getter @Setter
    private Integer id_rol;
    @Getter @Setter
    private Integer id_carga_persona;
    @Getter @Setter
    private Integer id_tipo_documento;
    @Getter @Setter
    private String password;


}
