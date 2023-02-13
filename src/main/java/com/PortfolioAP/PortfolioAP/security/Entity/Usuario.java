package com.PortfolioAP.PortfolioAP.security.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import javax.persistence.ManyToMany;
import javax.persistence.FetchType;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @NotNull

    private String nombre;
    @NotNull
    @Column(unique = true)
    private String NombreUsuario;
    @NotNull
    @Column(unique = true)
    private String email;
    @NotNull
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name="usuario_id"), inverseJoinColumns = @JoinColumn(name="rol_id"))
    private Set<Rol> roles = new HashSet<>();
    public Usuario() {
    }

    public Usuario( String nombre, String nombreUsuario, String email, String password) {
        this.nombre = nombre;
        NombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        NombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }


}
