package com.PortfolioAP.PortfolioAP.Interface;

import com.PortfolioAP.PortfolioAP.Entity.Educacion;

import java.util.List;
import java.util.Optional;

public interface IEducacioSer {

    public List<Educacion>list();

    public Optional<Educacion>getNombreEducacion(String nombreEdu);

    public Optional<Educacion>getOne(int id);

    public void save(Educacion educacion);

    public void delete(int id);

    public boolean exitsById(int id);

    public boolean exitsByNombreEdu(String nombreEducacion);
}
