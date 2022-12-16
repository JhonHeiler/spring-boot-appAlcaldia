package com.alcaldia.appAlcaldia.login;

import com.alcaldia.appAlcaldia.modelos.Permisos;

import java.util.List;

public class PermisoRolLogin {

    private String rol;
    private String user;
    private List<Permisos> permisos;

    public PermisoRolLogin(String rol, String user, List<Permisos> permisos) {
        this.rol = rol;
        this.user = user;
        this.permisos = permisos;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<Permisos> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<Permisos> permisos) {
        this.permisos = permisos;
    }
}
