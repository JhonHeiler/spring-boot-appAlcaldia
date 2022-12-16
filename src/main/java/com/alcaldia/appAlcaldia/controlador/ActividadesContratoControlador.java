package com.alcaldia.appAlcaldia.controlador;

import com.alcaldia.appAlcaldia.modelos.ActividadesContrato;
import com.alcaldia.appAlcaldia.modelos.Contratos;
import com.alcaldia.appAlcaldia.repositorio.ActividadesContratoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/actividadescontrato")
@CrossOrigin(origins = "http://localhost:4200")
public class ActividadesContratoControlador {
    @Autowired
    private ActividadesContratoRepositorio actividadesContratoRepositorio;

    @GetMapping
    public List<ActividadesContrato> consultarActividadesContrato(){
        return actividadesContratoRepositorio.findAll();
    }

    @PostMapping
    public ActividadesContrato guardarTipoDocumento(@RequestBody ActividadesContrato actividadesContrato ){
        return actividadesContratoRepositorio.save(actividadesContrato);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        actividadesContratoRepositorio.deleteById(id);
    }

    @PutMapping
    public ActividadesContrato modificarTipoDocumento(@RequestBody ActividadesContrato actividadesContrato ){
        if(actividadesContratoRepositorio.existsById(actividadesContrato.getId_actividades_contrato())){
            return actividadesContratoRepositorio.save(actividadesContrato);
        }
        return null;
    }

    @GetMapping("/{id}")
    public Optional<ActividadesContrato> consultaractividadesContratoId(@PathVariable("id") int id){
        return actividadesContratoRepositorio.findById(id);
    }

}