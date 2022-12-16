package com.alcaldia.appAlcaldia.controlador;

import com.alcaldia.appAlcaldia.modelos.Persona;
import com.alcaldia.appAlcaldia.modelos.PersonaCarga;
import com.alcaldia.appAlcaldia.repositorio.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/persona")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaControlador {

    @Autowired
    private PersonaRepositorio personaRepositorio;

    @GetMapping
    public List<Persona>consultarPersona(){
        return personaRepositorio.findAll();
    }

    @PostMapping
    public Persona guardarPersona(@RequestBody Persona persona ){
        return personaRepositorio.save(persona);
    }


    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        personaRepositorio.deleteById(id);
    }


    @PutMapping
    public Persona modificarPersona(@RequestBody Persona persona ){
        if(personaRepositorio.existsById(persona.getId_persona())){
            return personaRepositorio.save(persona);
        }
        return null;
    }

    @GetMapping("/{id}")
    public Optional<Persona> consultarPersonaid(@PathVariable("id") int id){
        return personaRepositorio.findById(id);
    }

}
