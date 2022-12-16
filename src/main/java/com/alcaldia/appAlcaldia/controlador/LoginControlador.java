package com.alcaldia.appAlcaldia.controlador;

import com.alcaldia.appAlcaldia.login.PermisoRolLogin;
import com.alcaldia.appAlcaldia.modelos.*;
import com.alcaldia.appAlcaldia.repositorio.PermisosRepositorio;
import com.alcaldia.appAlcaldia.repositorio.PersonaRepositorio;
import com.alcaldia.appAlcaldia.repositorio.RolRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/session")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginControlador {
    @Autowired
    private PersonaRepositorio personaRepositorio;

    @Autowired
    private PermisosRepositorio permisosRepositorio;

    @Autowired
    private RolRepositorio rolRepositorio;

    @PostMapping
    public PermisoRolLogin auth(@RequestBody Usuario usuario) {
        List<Persona> listaPersona = personaRepositorio.findAll();
        for (Persona p: listaPersona) {
            if(p.getCorreo().equals(usuario.getCorreo())  && p.getPassword().equals(usuario.getPassword())){
                return getRol(p.getId_rol(), p.getNombre());
            }
        }
        return null;
    }

    public PermisoRolLogin getRol(int id, String user){
        List<Rol> rol = rolRepositorio.findAll();
        for (Rol r: rol) {
            if(r.getId_rol() == id){
                List<Permisos> pm = getPermiso(r.getId_rol());
                return new PermisoRolLogin(r.getNombre(),user,pm);
            }
        }
        return null;
    }

    public List<Permisos> getPermiso(int id){
        List<Permisos> permisos = permisosRepositorio.findAll();
        List<Permisos> listPermiso = new ArrayList<>();
        for (Permisos pm: permisos) {
            if(pm.getId_rol() == id){
                listPermiso.add(pm);
            }
        }
        return (listPermiso.size() != 0) ? listPermiso : null;
    }

}
