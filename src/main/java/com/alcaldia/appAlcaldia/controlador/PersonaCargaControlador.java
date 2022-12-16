package com.alcaldia.appAlcaldia.controlador;

import com.alcaldia.appAlcaldia.modelos.Permisos;
import com.alcaldia.appAlcaldia.modelos.PersonaCarga;
import com.alcaldia.appAlcaldia.repositorio.PersonaCargaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/personacarga")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaCargaControlador {
    @Autowired
    private PersonaCargaRepositorio personaCargaRepositorio;

    @GetMapping
    public List<PersonaCarga> consultarPersonaCarga(){
        return personaCargaRepositorio.findAll();
    }


    @PostMapping
    public PersonaCarga guardarPersonaCarga(@RequestBody PersonaCarga personaCarga ){
        return personaCargaRepositorio.save(personaCarga);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        personaCargaRepositorio.deleteById(id);
    }

    @PutMapping
    public PersonaCarga modificarPersonaCarga(@RequestBody PersonaCarga personaCarga ){
        if(personaCargaRepositorio.existsById(personaCarga.getId_persona_carga())){
            return personaCargaRepositorio.save(personaCarga);
        }
        return null;
    }

    @GetMapping("/{id}")
    public Optional<PersonaCarga> consultarPersonaCargaid(@PathVariable("id") int id){
        return personaCargaRepositorio.findById(id);
    }

}