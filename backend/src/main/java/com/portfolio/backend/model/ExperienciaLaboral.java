package com.portfolio.backend.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ExperienciaLaboral {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombreEmpresa;
    private String periodo;
    private String funcion;
    private String tituloPuesto;
    private String logoEmpresa;

    public ExperienciaLaboral() {
    }

    public ExperienciaLaboral(Long id, String nombreEmpresa, String periodo, String funcion, String tituloPuesto, String logoEmpresa) {
        this.id = id;
        this.nombreEmpresa = nombreEmpresa;
        this.periodo = periodo;
        this.funcion = funcion;
        this.tituloPuesto = tituloPuesto;
        this.logoEmpresa = logoEmpresa;
    }

}
