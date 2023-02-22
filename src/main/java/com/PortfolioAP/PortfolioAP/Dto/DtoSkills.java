package com.PortfolioAP.PortfolioAP.Dto;

public class DtoSkills {

    private String nombre;
    private int porcentaje;

    private int radius;

    private String colorExterno;

    private String colorInterno;

    public DtoSkills(String nombre, int porcentaje, int radius, String colorExterno, String colorInterno) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.radius = radius;
        this.colorExterno = colorExterno;
        this.colorInterno = colorInterno;
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
}
