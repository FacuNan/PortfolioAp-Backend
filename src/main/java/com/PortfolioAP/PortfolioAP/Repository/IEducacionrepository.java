package com.PortfolioAP.PortfolioAP.Repository;

import com.PortfolioAP.PortfolioAP.Entity.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEducacionrepository extends JpaRepository<Educacion, Integer> {

    public Optional<Educacion> findByTitulo(String titulo);

    boolean existsBytitulo(String titulo);
}
