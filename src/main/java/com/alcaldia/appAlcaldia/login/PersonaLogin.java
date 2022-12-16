package com.alcaldia.appAlcaldia.login;

public class PersonaLogin {
    private Integer documento;
    private String nombre;
    private String correo;
    private String rol;
    private String url;
    private Integer create;
    private  Integer read;
    private  Integer update;
    private Integer delete;

    public PersonaLogin(Integer documento, String nombre, String correo, String rol, String url, Integer create, Integer read, Integer update, Integer delete) {
        this.documento = documento;
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
        this.url = url;
        this.create = create;
        this.read = read;
        this.update = update;
        this.delete = delete;
    }
}

