package com.PortfolioAP.PortfolioAP.Dto;

import javax.validation.constraints.NotBlank;

public class DtoExperiencia {
    private int id;
    @NotBlank
    private String nombreE;
    @NotBlank
    private String institucion;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String fechaInicio;
    @NotBlank
    private String fechaTerminacion;

    public DtoExperiencia() {
    }

    public DtoExperiencia(int id, String nombreE, String institucion, String descripcion, String fechaInicio, String fechaTerminacion) {
        this.id = id;
        this.nombreE = nombreE;
        this.institucion = institucion;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaTerminacion = fechaTerminacion;
    }


    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaTerminacion() {
        return fechaTerminacion;
    }

    public void setFechaTerminacion(String fechaTerminacion) {
        this.fechaTerminacion = fechaTerminacion;
    }
}
