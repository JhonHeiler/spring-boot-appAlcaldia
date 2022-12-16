package com.alcaldia.appAlcaldia.controlador;

import com.alcaldia.appAlcaldia.modelos.Persona;
import com.alcaldia.appAlcaldia.modelos.Prueba;
import com.alcaldia.appAlcaldia.modelos.TipoDocumento;
import com.alcaldia.appAlcaldia.repositorio.PruebaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/api/prueba")
@CrossOrigin(origins = "http://localhost:4200")
public class PruebaControlador {
    @Autowired
    private PruebaRepositorio pruebaRepositorio;

    @GetMapping
    public List<Prueba>consultarPrueba(){ return pruebaRepositorio.findAll();}


    @PostMapping
    public Prueba guardarPrueba(@RequestBody Prueba prueba){
        return pruebaRepositorio.save(prueba);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){pruebaRepositorio.deleteById(id);}

    @PutMapping
    public Prueba modificarTipoDocumento(@RequestBody Prueba prueba ){
        if(pruebaRepositorio.existsById(prueba.getId_prueba())){
            return pruebaRepositorio.save(prueba);
        }
        return null;
    }


    @GetMapping("/{id}")
    public Optional<Prueba> consultarPrueba(@PathVariable("id") int id){
        return pruebaRepositorio.findById(id);
    }

}
