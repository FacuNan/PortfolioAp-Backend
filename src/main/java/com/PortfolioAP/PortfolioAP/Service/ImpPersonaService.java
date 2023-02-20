package com.PortfolioAP.PortfolioAP.Service;

import com.PortfolioAP.PortfolioAP.Entity.Persona;
import com.PortfolioAP.PortfolioAP.Interface.IPersonaService;
import com.PortfolioAP.PortfolioAP.Repository.IPersonarepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ImpPersonaService implements IPersonaService {
    @Autowired
    IPersonarepository ipersonarepository;

    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = ipersonarepository.findAll();
        return persona;
    }

    @Override
    public Optional<Persona> getOne(long id) {
        return ipersonarepository.findById(id);
    }

    @Override
    public void savePersona(Persona persona) {
        ipersonarepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        ipersonarepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = ipersonarepository.findById(id).orElse(null);
        return persona;
    }
}