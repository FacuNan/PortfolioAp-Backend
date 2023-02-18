package com.PortfolioAP.PortfolioAP.Interface;

import com.PortfolioAP.PortfolioAP.Entity.Experiencia;

import java.util.List;
import java.util.Optional;

public interface IExperienciaSer {
    public List<Experiencia> list();
    public Optional<Experiencia> getOne(int id);

    public Optional<Experiencia> getNombre(String nombreExperiencia);

    public void save(Experiencia expe);

    public void delete(int id);


    public boolean existsById(int id);

    public boolean exitsBynombreExp(String nombreExp);

}
