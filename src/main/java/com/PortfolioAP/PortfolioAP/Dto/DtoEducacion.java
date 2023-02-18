package com.PortfolioAP.PortfolioAP.Dto;

import javax.validation.constraints.NotBlank;

public class DtoEducacion {
    private int id;
    @NotBlank
    private String titulo;
    @NotBlank
    private String institucion;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String fechaInicio;
    @NotBlank
    private String fechaTerminacion;

    //constructores

    public DtoEducacion() {
    }

    public DtoEducacion(String titulo, String institucion, String descripcion, String fechaInicio, String fechaTerminacion) {
        this.titulo = titulo;
        this.institucion = institucion;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaTerminacion = fechaTerminacion;
    }

    //getters and Setters


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
