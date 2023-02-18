package com.PortfolioAP.PortfolioAP.Service;

import com.PortfolioAP.PortfolioAP.Entity.Educacion;
import com.PortfolioAP.PortfolioAP.Interface.IEducacioSer;
import com.PortfolioAP.PortfolioAP.Repository.IEducacionrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SEducacion implements IEducacioSer {
    @Autowired
    IEducacionrepository ieducacionRepository;

    @Override
    public List<Educacion> list() {
        return ieducacionRepository.findAll();
    }

    @Override
    public Optional<Educacion> getNombreEducacion(String nombreEdu) {
        return ieducacionRepository.findByTitulo(nombreEdu);
    }

    @Override
    public Optional<Educacion> getOne(int id) {
        return ieducacionRepository.findById(id);
    }

    @Override
    public void save(Educacion educacion) {
        ieducacionRepository.save(educacion);

    }

    @Override
    public void delete(int id) {
        ieducacionRepository.deleteById(id);

    }

    @Override
    public boolean exitsById(int id) {
        return ieducacionRepository.existsById(id);
    }

    @Override
    public boolean exitsByNombreEdu(String nombreEducacion) {
        return ieducacionRepository.existsBytitulo(nombreEducacion);
    }
}
