package com.portfolio.backend.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String ocupacion;
    private String ubicacion;
    private String telefono;
    private String email;
    private String urlImagenPerfil;
    private String urlImagenBanner;
    private String urlGit;
    private String urlCv;

    public Persona() {
    }

    public Persona(Long id, String nombre, String ocupacion, String ubicacion, String telefono, String email, String urlImagenPerfil, String urlImagenBanner, String urlGit, String urlCv) {
        this.id = id;
        this.nombre = nombre;
        this.ocupacion = ocupacion;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
        this.email = email;
        this.urlImagenPerfil = urlImagenPerfil;
        this.urlImagenBanner = urlImagenBanner;
        this.urlGit = urlGit;
        this.urlCv = urlCv;
    }

}
