package com.PortfolioAP.PortfolioAP.Repository;

import com.PortfolioAP.PortfolioAP.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IPersonarepository extends JpaRepository<Persona, Long> {

}
