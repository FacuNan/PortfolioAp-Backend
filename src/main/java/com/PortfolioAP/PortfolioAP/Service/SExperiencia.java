package com.PortfolioAP.PortfolioAP.Service;

import com.PortfolioAP.PortfolioAP.Entity.Experiencia;
import com.PortfolioAP.PortfolioAP.Interface.IExperienciaSer;
import com.PortfolioAP.PortfolioAP.Repository.IExperienciarepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SExperiencia implements IExperienciaSer {
@Autowired
    IExperienciarepository IexperienciaRepository;

    @Override
    public List<Experiencia> list() {
        return IexperienciaRepository.findAll();
    }

    @Override
    public Optional<Experiencia> getOne(int id) {
        return IexperienciaRepository.findById(id);
    }

    @Override
    public Optional<Experiencia> getNombre(String nombreExperiencia) {
        return IexperienciaRepository.findByNombreE(nombreExperiencia);
    }

    @Override
    public void save(Experiencia expe) {
        IexperienciaRepository.save(expe);
    }

    @Override
    public void delete(int id) {

        IexperienciaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(int id) {
        return IexperienciaRepository.existsById(id);
    }

    @Override
    public boolean exitsBynombreExp(String nombreExp) {
        return  IexperienciaRepository.existsByNombreE(nombreExp);
    }
}
