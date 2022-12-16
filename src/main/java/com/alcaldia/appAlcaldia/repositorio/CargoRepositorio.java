package com.alcaldia.appAlcaldia.repositorio;

import com.alcaldia.appAlcaldia.modelos.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepositorio extends JpaRepository<Cargo, Integer> {
}
