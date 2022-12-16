package com.alcaldia.appAlcaldia.controlador;

import com.alcaldia.appAlcaldia.modelos.Categoria;
import com.alcaldia.appAlcaldia.modelos.Contratos;
import com.alcaldia.appAlcaldia.repositorio.ContratosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contratos")
@CrossOrigin(origins = "http://localhost:4200")
public class ContratosControlador {
    @Autowired
    private ContratosRepositorio contratosRepositorio;

    @GetMapping
    public List<Contratos> consultarContratos(){
        return contratosRepositorio.findAll();
    }

    @PostMapping
    public Contratos guardarContratos(@RequestBody Contratos contratos ){
        return contratosRepositorio.save(contratos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        contratosRepositorio.deleteById(id);
    }

    @PutMapping
    public Contratos modificarContratos(@RequestBody Contratos contratos ){
        if(contratosRepositorio.existsById(contratos.getId_contratos())){
            return contratosRepositorio.save(contratos
            );
        }
        return null;
    }
    @GetMapping("/{id}")
    public Optional<Contratos> consultarcontratosId(@PathVariable("id") int id){
        return contratosRepositorio.findById(id);
    }

}
