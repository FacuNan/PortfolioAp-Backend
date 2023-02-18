package com.PortfolioAP.PortfolioAP.Dto;

import javax.validation.constraints.NotBlank;

public class DtoProyectos {
    private int id;
    @NotBlank
    private String nombreProyecto;
    @NotBlank
    private String img;
    @NotBlank
    private String descripcion;

    //constructores

    public DtoProyectos() {
    }

    public DtoProyectos(String nombreProyecto, String img, String descripcion) {
        this.nombreProyecto = nombreProyecto;
        this.img = img;
        this.descripcion = descripcion;
    }

    //Getters and Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
