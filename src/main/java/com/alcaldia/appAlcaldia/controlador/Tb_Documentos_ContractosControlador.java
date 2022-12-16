package com.alcaldia.appAlcaldia.controlador;

import com.alcaldia.appAlcaldia.modelos.Rol;
import com.alcaldia.appAlcaldia.modelos.Tb_Documentos_Contractos;
import com.alcaldia.appAlcaldia.repositorio.Tb_Documentos_ContractosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tb_documentos_contractos")
@CrossOrigin(origins = "http://localhost:4200")
public class Tb_Documentos_ContractosControlador {

    @Autowired
    private Tb_Documentos_ContractosRepositorio tb_documentos_contractosRepositorio;

    @GetMapping
    public List<Tb_Documentos_Contractos> consultarTb_Documentos_Contractos(){
        return tb_documentos_contractosRepositorio.findAll();
    }

    @PostMapping
    public Tb_Documentos_Contractos guardarTb_Documentos_Contractos(@RequestBody Tb_Documentos_Contractos tb_documentos_contractos ){
        return tb_documentos_contractosRepositorio.save(tb_documentos_contractos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        tb_documentos_contractosRepositorio.deleteById(id);
    }

    @PutMapping
    public Tb_Documentos_Contractos modificarTb_Documentos_Contractos (@RequestBody Tb_Documentos_Contractos tb_documentos_contractos ){
        if(tb_documentos_contractosRepositorio.existsById(tb_documentos_contractos.getId_tb_documentos_contractos())){
            return tb_documentos_contractosRepositorio.save(tb_documentos_contractos);
        }
        return null;
    }

    @GetMapping("/{id}")
    public Optional<Tb_Documentos_Contractos> consultarTb_Documentos_Contractos(@PathVariable("id") int id){
        return tb_documentos_contractosRepositorio.findById(id);
    }

}
