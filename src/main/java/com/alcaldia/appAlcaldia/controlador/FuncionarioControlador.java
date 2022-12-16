package com.alcaldia.appAlcaldia.controlador;

import com.alcaldia.appAlcaldia.modelos.Categoria;
import com.alcaldia.appAlcaldia.modelos.Funcionario;
import com.alcaldia.appAlcaldia.repositorio.FuncionarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/funcionario")
@CrossOrigin(origins = "http://localhost:4200")
public class FuncionarioControlador {
    @Autowired
    private FuncionarioRepositorio funcionarioRepositorio;

    @GetMapping
    public List<Funcionario> consultarFuncionario(){
        return funcionarioRepositorio.findAll();
    }
    @PostMapping
    public Funcionario guardarFuncionario(@RequestBody Funcionario funcionario ){
        return funcionarioRepositorio.save(funcionario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        funcionarioRepositorio.deleteById(id);
    }

    @PutMapping
    public Funcionario modificarTipoDocumento(@RequestBody Funcionario funcionario ){
        if(funcionarioRepositorio.existsById(funcionario.getId_funcionario())){
            return funcionarioRepositorio.save(funcionario);
        }
        return null;
    }

    @GetMapping("/{id}")
    public Optional<Funcionario> consultarFuncionarioid(@PathVariable("id") int id){
        return funcionarioRepositorio.findById(id);
    }

}
