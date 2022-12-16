package com.alcaldia.appAlcaldia.controlador;

import com.alcaldia.appAlcaldia.modelos.Cargo;
import com.alcaldia.appAlcaldia.repositorio.CargoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cargo")
@CrossOrigin(origins = "http://localhost:4200")
public class CargoControlador {
    @Autowired
    private CargoRepositorio cargoRepositorio;

    @GetMapping
    public List<Cargo> consultarCargo(){
        return cargoRepositorio.findAll();
    }

    @PostMapping
    public Cargo guardarCargo(@RequestBody Cargo cargo ){
        return cargoRepositorio.save(cargo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        cargoRepositorio.deleteById(id);
    }

    @PutMapping
    public Cargo modificar(@RequestBody Cargo cargo ){
        return cargoRepositorio.save(cargo);

    }
    @GetMapping("/{id}")
    public Optional<Cargo> consultarCargoId(@PathVariable("id") int id){
        return cargoRepositorio.findById(id);
    }
}
