package com.PortfolioAP.PortfolioAP.Repository;

import com.PortfolioAP.PortfolioAP.Entity.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IExperienciarepository extends JpaRepository<Experiencia, Integer> {
    public Optional<Experiencia> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);


}
