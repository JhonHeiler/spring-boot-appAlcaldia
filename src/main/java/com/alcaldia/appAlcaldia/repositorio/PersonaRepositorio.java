package com.alcaldia.appAlcaldia.repositorio;

import com.alcaldia.appAlcaldia.modelos.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepositorio extends JpaRepository<Persona, Integer> {
}
