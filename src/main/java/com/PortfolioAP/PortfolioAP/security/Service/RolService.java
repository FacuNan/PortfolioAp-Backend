package com.PortfolioAP.PortfolioAP.security.Service;

import com.PortfolioAP.PortfolioAP.security.Entity.Rol;
import com.PortfolioAP.PortfolioAP.security.Repository.RolRepository;
import com.PortfolioAP.PortfolioAP.security.enums.RolNombre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RolService {
    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        rolRepository.save(rol);
    }
}
