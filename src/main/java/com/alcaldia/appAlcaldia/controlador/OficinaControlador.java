package com.alcaldia.appAlcaldia.controlador;

import com.alcaldia.appAlcaldia.modelos.Funcionario;
import com.alcaldia.appAlcaldia.modelos.Oficina;
import com.alcaldia.appAlcaldia.repositorio.OficinaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/oficina")
@CrossOrigin(origins = "http://localhost:4200")
public class OficinaControlador {
        @Autowired
        private OficinaRepositorio oficinaRepositorio;

    @GetMapping
    public List<Oficina> consultarOficina(){
        return oficinaRepositorio.findAll();
        }

        @PostMapping
        public Oficina guardarOficina(@RequestBody Oficina oficina ){
            return oficinaRepositorio.save(oficina);
        }

        @DeleteMapping("/{id}")
        public void eliminar(@PathVariable("id") int id){
            oficinaRepositorio.deleteById(id);
        }

        @PutMapping
        public Oficina modificarOficina(@RequestBody Oficina oficina ){
            if(oficinaRepositorio.existsById(oficina.getId_oficina())){
                return oficinaRepositorio.save(oficina);
            }
            return null;
        }

    @GetMapping("/{id}")
    public Optional<Oficina> consultarOficinaid(@PathVariable("id") int id){
        return oficinaRepositorio.findById(id);
    }

}
