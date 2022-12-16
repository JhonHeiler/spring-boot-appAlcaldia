package com.alcaldia.appAlcaldia.repositorio;

import com.alcaldia.appAlcaldia.modelos.Contratos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratosRepositorio extends JpaRepository <Contratos, Integer> {
}
