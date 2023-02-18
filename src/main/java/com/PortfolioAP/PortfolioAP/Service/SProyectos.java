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
        return iproyectoRepostory.findAll();
    }

    @Override
    public Optional<Proyectos> getNombreProyecto(String nombreProyecto) {
        return iproyectoRepostory.findByNombreProyecto(nombreProyecto);
    }

    @Override
    public Optional<Proyectos> getOne(int id) {
        return iproyectoRepostory.findById(id);
    }

    @Override
    public void save(Proyectos proyectos) {
        iproyectoRepostory.save(proyectos);

    }

    @Override
    public void delete(int id) {
        iproyectoRepostory.deleteById(id);
    }

    @Override
    public boolean exitsByNombre(String nombreProyecto) {
        return iproyectoRepostory.existsByNombreProyecto(nombreProyecto);
    }

    @Override
    public boolean exitsById(int id) {
        return iproyectoRepostory.existsById(id);
    }
}
