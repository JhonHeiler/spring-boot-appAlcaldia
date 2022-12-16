package com.alcaldia.appAlcaldia.controlador;

import com.alcaldia.appAlcaldia.modelos.Prueba;
import com.alcaldia.appAlcaldia.modelos.Rol;
import com.alcaldia.appAlcaldia.repositorio.RolRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
    @RequestMapping("/api/rol")
@CrossOrigin(origins = "http://localhost:4200")
public class RolControlador {
    @Autowired
    private RolRepositorio rolRepositorio;

    @GetMapping
    public List<Rol> consultarRol(){
        return rolRepositorio.findAll();
    }

    @PostMapping
    public Rol guardarRol(@RequestBody Rol rol ){
        return rolRepositorio.save(rol);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        rolRepositorio.deleteById(id);
    }

    @PutMapping
    public Rol modificarTipoDocumento(@RequestBody Rol rol ){
        if(rolRepositorio.existsById(rol.getId_rol())){
            return rolRepositorio.save(rol);
        }
        return null;
    }
    @GetMapping("/{id}")
    public Optional<Rol> consultarRol(@PathVariable("id") int id){
        return rolRepositorio.findById(id);
    }

}
