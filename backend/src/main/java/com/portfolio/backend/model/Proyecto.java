package com.portfolio.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombreProyecto;
    private String descripcionProyecto;
    private String urlProyecto;
    private String fechaProyecto;
    private String urlImagen;

    public Proyecto() {
    }

    public Proyecto(Long id, String nombreProyecto, String descripcionProyecto, String urlProyecto, String fechaProyecto, String urlImagen) {
        this.id = id;
        this.nombreProyecto = nombreProyecto;
        this.descripcionProyecto = descripcionProyecto;
        this.urlProyecto = urlProyecto;
        this.fechaProyecto = fechaProyecto;
        this.urlImagen = urlImagen;
    }

}
