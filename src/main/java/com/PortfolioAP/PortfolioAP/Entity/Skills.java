package com.PortfolioAP.PortfolioAP.Entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int porcentaje;

    private int radius;
    
    private String colorExterno;
    
    private String colorInterno;
    private String imagen;


    //constructores


    public Skills() {
    }

    public Skills(String nombre, int porcentaje, int radius, String colorExterno, String colorInterno, String Imagen) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.radius = radius;
        this.colorExterno = colorExterno;
        this.colorInterno = colorInterno;
        this.imagen=imagen;
    }

    //Geters andSetters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getColorExterno() {
        return colorExterno;
    }

    public void setColorExterno(String colorExterno) {
        this.colorExterno = colorExterno;
    }

    public String getColorInterno() {
        return colorInterno;
    }

    public void setColorInterno(String colorInterno) {
        this.colorInterno = colorInterno;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    
}
