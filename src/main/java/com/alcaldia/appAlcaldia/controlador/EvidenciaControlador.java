package com.alcaldia.appAlcaldia.controlador;

import com.alcaldia.appAlcaldia.input.EvidenciaInput;
import com.alcaldia.appAlcaldia.modelos.ActividadesContrato;
import com.alcaldia.appAlcaldia.modelos.Evidencia;
import com.alcaldia.appAlcaldia.repositorio.EvidenciaRepositorio;
import com.github.slugify.Slugify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/evidencia")
@CrossOrigin(origins = "http://localhost:4200")
public class EvidenciaControlador {

    @Autowired
    private EvidenciaRepositorio evidenciaRepositorio;

    @GetMapping
    public List<Evidencia> consultarEvidencia(){
        return evidenciaRepositorio.findAll();
    }

    @PostMapping
    public Evidencia guardarEvidencia(@RequestBody EvidenciaInput evidenciaInput)throws IOException {
        String imagenBase64 = evidenciaInput.getImagen();
        String[] base64ToArray = imagenBase64.split(";base64,");
        byte[] archivoByte = Base64.getDecoder().decode(base64ToArray[1]);

        String filename = evidenciaInput.getRuta_almacenamiento();
        OutputStream out = new FileOutputStream("src/main/resources/static/images/"+filename);
        out.write(archivoByte);
        out.close();
        Evidencia evidencia = new Evidencia(evidenciaInput.getNombre(),evidenciaInput.getDescripcion(),evidenciaInput.getImagen(),evidenciaInput.getFecha_cargue(),
                evidenciaInput.getEstado(),evidenciaInput.getId_actividades_contrato(),evidenciaInput.getId_prueba(),evidenciaInput.getId_persona_carga());
        return evidenciaRepositorio.save(evidencia);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        evidenciaRepositorio.deleteById(id);
    }

    @PutMapping
    public Evidencia modificarTipoDocumento(@RequestBody Evidencia evidencia ){
        if(evidenciaRepositorio.existsById(evidencia.getId_evidencia())){
            return evidenciaRepositorio.save(evidencia);
        }
        return null;
    }
    @GetMapping("/{id}")
    public Optional<Evidencia> consultarevidenciaId(@PathVariable("id") int id){
        return evidenciaRepositorio.findById(id);
    }


}
