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
    @NotBlank
    private String link;

    //constructores

    public DtoProyectos() {
    }

    public DtoProyectos(String nombreProyecto, String img, String descripcion, String link) {
        this.nombreProyecto = nombreProyecto;
        this.img = img;
        this.descripcion = descripcion;
        this.link = link;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    
}
