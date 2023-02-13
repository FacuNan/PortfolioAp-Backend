package com.PortfolioAP.PortfolioAP.security.Repository;

import com.PortfolioAP.PortfolioAP.security.Entity.Rol;
import com.PortfolioAP.PortfolioAP.security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

    Optional<Rol> findByRolNombre(RolNombre rolNombre);


}
