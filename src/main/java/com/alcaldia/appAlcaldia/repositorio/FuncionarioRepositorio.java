package com.alcaldia.appAlcaldia.repositorio;


import com.alcaldia.appAlcaldia.modelos.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepositorio extends JpaRepository <Funcionario,Integer> {
}