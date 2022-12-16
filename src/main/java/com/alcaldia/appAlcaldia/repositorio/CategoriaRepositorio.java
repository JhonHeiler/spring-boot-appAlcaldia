package com.alcaldia.appAlcaldia.repositorio;

import com.alcaldia.appAlcaldia.modelos.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepositorio extends JpaRepository <Categoria, Integer> {

}
