package com.PortfolioAP.PortfolioAP.Service;

import com.PortfolioAP.PortfolioAP.Entity.Proyectos;
import com.PortfolioAP.PortfolioAP.Interface.IProyectosSer;
import com.PortfolioAP.PortfolioAP.Repository.IProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SProyectos implements IProyectosSer {
    @Autowired
    IProyectoRepository iproyectoRepostory;


    @Override
    public List<Proyectos> list() {
        return null;
    }

    @Override
    public Optional<Proyectos> getNombreProyecto(String nombreProyecto) {
        return Optional.empty();
    }

    @Override
    public Optional<Proyectos> getOne(int id) {
        return Optional.empty();
    }

    @Override
    public void save(Proyectos proyectos) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public boolean exitsByNombre(String nombreProyecto) {
        return false;
    }

    @Override
    public boolean exitsById(int id) {
        return false;
    }
}
