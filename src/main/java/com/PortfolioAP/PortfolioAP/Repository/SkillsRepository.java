package com.PortfolioAP.PortfolioAP.Repository;

import com.PortfolioAP.PortfolioAP.Entity.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkillsRepository extends JpaRepository<Skills, Integer> {
    public Optional<Skills> findByNombre(String nombre);

    public boolean existsByNombre(String nombre);


}
