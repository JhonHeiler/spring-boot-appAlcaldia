package com.alcaldia.appAlcaldia.controlador;

import com.alcaldia.appAlcaldia.modelos.Cargo;
import com.alcaldia.appAlcaldia.modelos.Categoria;
import com.alcaldia.appAlcaldia.repositorio.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categoria")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoriaControlador {
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @GetMapping
    public List<Categoria> consultarcategoria(){
        return categoriaRepositorio.findAll();
    }

    @PostMapping
    public Categoria guardarCategoria(@RequestBody Categoria categoria ){
        return categoriaRepositorio.save(categoria);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        categoriaRepositorio.deleteById(id);
    }

    @PutMapping
    public Categoria modificarTipoDocumento(@RequestBody Categoria categoria ){
        if(categoriaRepositorio.existsById(categoria.getId_categoria())){
            return categoriaRepositorio.save(categoria);
        }
        return null;
    }
    @GetMapping("/{id}")
    public Optional<Categoria> consultarcategoriaId(@PathVariable("id") int id){
        return categoriaRepositorio.findById(id);
    }

    }

