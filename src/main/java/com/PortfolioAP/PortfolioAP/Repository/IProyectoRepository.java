package com.PortfolioAP.PortfolioAP.Repository;

import com.PortfolioAP.PortfolioAP.Entity.Proyectos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProyectoRepository extends JpaRepository<Proyectos, Integer> {
    public Optional<Proyectos> findByNombreProyecto(String nombreProyecto);

    public boolean existsByNombreProyecto(String nombreProyecto);



}
