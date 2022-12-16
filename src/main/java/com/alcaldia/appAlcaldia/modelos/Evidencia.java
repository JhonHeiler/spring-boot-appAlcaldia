package com.alcaldia.appAlcaldia.modelos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Evidencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evidencia", unique = true, nullable = false)
    @Getter @Setter
    private Integer id_evidencia;
    @Getter @Setter
    private String nombre;
    @Getter @Setter
    private String descripcion;
    @Getter @Setter
    private String imagen;
    @Getter @Setter
    private Date fecha_cargue;
    @Getter @Setter
    private String estado;
    @Getter @Setter
    private Integer id_actividades_contrato;
    @Getter @Setter
    private Integer id_prueba;
    @Getter @Setter
    private Integer id_persona_carga;

    public Evidencia(String nombre, String descripcion, String imagen, Date fecha_cargue, String estado, Integer id_actividades_contrato, Integer id_prueba, Integer id_persona_carga) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.fecha_cargue = fecha_cargue;
        this.estado = estado;
        this.id_actividades_contrato = id_actividades_contrato;
        this.id_prueba = id_prueba;
        this.id_persona_carga = id_persona_carga;
    }
    public Evidencia(){

    }

    @Override
    public String toString() {
        return "Evidencia{" +
                "id_evidencia=" + id_evidencia +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + "imagen" + '\'' +
                ", fecha_cargue=" + fecha_cargue +
                ", estado='" + estado + '\'' +
                ", id_actividades_contrato=" + id_actividades_contrato +
                ", id_prueba=" + id_prueba +
                ", id_persona_carga=" + id_persona_carga +
                '}';
    }
}

