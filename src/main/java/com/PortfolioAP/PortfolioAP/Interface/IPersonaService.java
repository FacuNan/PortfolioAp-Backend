package com.PortfolioAP.PortfolioAP.Interface;

import com.PortfolioAP.PortfolioAP.Entity.Experiencia;
import com.PortfolioAP.PortfolioAP.Entity.Persona;

import java.util.List;
import java.util.Optional;

public interface IPersonaService {

    public List<Persona> getPersona();

    public Optional<Persona> getOne(int id);
    public void savePersona(Persona persona);

    public void deletePersona(int id);

    public Persona findPersona(int id);

}
