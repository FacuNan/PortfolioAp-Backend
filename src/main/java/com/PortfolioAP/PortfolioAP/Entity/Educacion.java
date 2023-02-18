package com.PortfolioAP.PortfolioAP.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private String institucion;
    private String descripcion;
    private String fechaInicio;
    private String fechaTerminacion;

    //constructores


    public Educacion() {
    }

    public Educacion(String titulo, String institucion, String descripcion, String fechaInicio, String fechaTerminacion) {
        this.titulo = titulo;
        this.institucion = institucion;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaTerminacion = fechaTerminacion;
    }


    //Getters and Setters


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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
