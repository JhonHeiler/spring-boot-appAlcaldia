package com.alcaldia.appAlcaldia.controlador;

import com.alcaldia.appAlcaldia.modelos.ResponseApi;
import com.alcaldia.appAlcaldia.modelos.Tb_Documentos_Contractos;
import com.alcaldia.appAlcaldia.modelos.TipoDocumento;
import com.alcaldia.appAlcaldia.repositorio.TipoDocumentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tipo_documento")
@CrossOrigin(origins = "http://localhost:4200")
public class TipoDocumentoContrlador {
    @Autowired
    private TipoDocumentoRepositorio tipoDocumentoRepositorio;

    @GetMapping
    public List<TipoDocumento>consultarTipoDocumento(){
        return tipoDocumentoRepositorio.findAll();
    }


    @PostMapping
    public ResponseApi guardarTipoDocumento(@RequestBody TipoDocumento tipoDocumento ){
        tipoDocumentoRepositorio.save(tipoDocumento);
        ResponseApi responseApi= new ResponseApi();
        responseApi.setSuccess(true);
        responseApi.setMessage("datos guardados con exitos");
        return responseApi;

    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        tipoDocumentoRepositorio.deleteById(id);
    }

    @PutMapping
    public TipoDocumento modificarTipoDocumento(@RequestBody TipoDocumento tipoDocumento ){
      if(tipoDocumentoRepositorio.existsById(tipoDocumento.getId_tipo_documento())){
            return tipoDocumentoRepositorio.save(tipoDocumento);
        }
        return null;
    }
    @GetMapping("/{id}")
    public Optional<TipoDocumento> consultarTipoDocumento(@PathVariable("id") int id){
        return tipoDocumentoRepositorio.findById(id);
    }

}
