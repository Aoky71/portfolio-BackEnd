
package com.portfolio.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private String nombreInstituto;
    private String fechaInicio;
    private String descripcionInstitucion;

    public Educacion() {
    }

    public Educacion(Long id, String nombreInstituto, String fechaInicio, String descripcionInstitucion) {
        this.id = id;
        this.nombreInstituto = nombreInstituto;
        this.fechaInicio = fechaInicio;
        this.descripcionInstitucion = descripcionInstitucion;
    }
    
    
}
