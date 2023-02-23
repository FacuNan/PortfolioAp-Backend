package com.PortfolioAP.PortfolioAP.Dto;

public class DtoPersona {
    private String nombre;
    private String apellido;
    private String img;
    private String biografia;


    //constructores

    public DtoPersona(String nombre, String apellido, String img, String biografia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.biografia = biografia;
    }

    //Geters and Setters


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
}
