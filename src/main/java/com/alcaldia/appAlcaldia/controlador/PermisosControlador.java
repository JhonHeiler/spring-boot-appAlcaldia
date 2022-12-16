package com.alcaldia.appAlcaldia.controlador;

import com.alcaldia.appAlcaldia.modelos.Oficina;
import com.alcaldia.appAlcaldia.modelos.Permisos;
import com.alcaldia.appAlcaldia.modelos.TipoDocumento;
import com.alcaldia.appAlcaldia.repositorio.PermisosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/permisos")
@CrossOrigin(origins = "http://localhost:4200")
public class PermisosControlador {
    @Autowired
    private PermisosRepositorio permisosRepositorio;

    @GetMapping
    public List<Permisos> consultarPermisos(){
        return permisosRepositorio.findAll();
    }

    @PostMapping
    public Permisos guardarPermisos(@RequestBody Permisos permisos ){
        return permisosRepositorio.save(permisos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        permisosRepositorio.deleteById(id);
    }
    @PutMapping
    public Permisos modificarPermisos(@RequestBody Permisos permisos ){
        if(permisosRepositorio.existsById(permisos.getId_permisos())){
            return permisosRepositorio.save(permisos);
        }
        return null;
    }
    @GetMapping("/{id}")
    public Optional<Permisos> consultarPermisosid(@PathVariable("id") int id){
        return permisosRepositorio.findById(id);
    }

}
