package com.alcaldia.appAlcaldia.controlador;

import com.alcaldia.appAlcaldia.modelos.Secretaria;
import com.alcaldia.appAlcaldia.repositorio.SecretariaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/api/secretaria")
@CrossOrigin(origins = "http://localhost:4200")
public class SecretariaControlador {
    @Autowired
    private SecretariaRepositorio secretariaRepositorio;

    @GetMapping
    public List<Secretaria>consultarSecretaria(){return secretariaRepositorio.findAll();}

    @PostMapping
    public Secretaria guardarSecretaria(@RequestBody Secretaria secretaria) {return secretariaRepositorio.save(secretaria);}

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {secretariaRepositorio.deleteById(id); }

        @PutMapping
        public Secretaria modificarSecretaria(@RequestBody Secretaria secretaria ){
            if(secretariaRepositorio.existsById(secretaria.getId_secretaria())){
                return secretariaRepositorio.save(secretaria);
            }
            return null;
        }

    @GetMapping("/{id}")
    public Optional<Secretaria> consultarSecretariaId(@PathVariable("id") int id){
        return secretariaRepositorio.findById(id);
    }



    }
