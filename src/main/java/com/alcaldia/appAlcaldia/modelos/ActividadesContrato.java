package com.alcaldia.appAlcaldia.modelos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class ActividadesContrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actividades_contrato", unique = true, nullable = false)
    @Getter @Setter
    private Integer id_actividades_contrato;
    @Getter @Setter
    private Integer id_contratos;
    @Getter @Setter
    private String indicador_de_resultado;
    @Getter @Setter
    private String nombre_actividad;

}
