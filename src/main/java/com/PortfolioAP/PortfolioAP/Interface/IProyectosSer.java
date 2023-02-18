package com.PortfolioAP.PortfolioAP.Interface;

import com.PortfolioAP.PortfolioAP.Entity.Proyectos;

import java.util.List;
import java.util.Optional;

public interface IProyectosSer {

    public List<Proyectos>list();

    public Optional<Proyectos>getNombreProyecto(String nombreProyecto);

    public Optional<Proyectos> getOne(int id);

    public void save(Proyectos proyectos);

    public void delete(int id);

    public boolean exitsByNombre(String nombreProyecto);

    public boolean exitsById(int id);


}
