package com.PortfolioAP.PortfolioAP.security.Service;

import com.PortfolioAP.PortfolioAP.security.Entity.Usuario;
import com.PortfolioAP.PortfolioAP.security.Repository.IUsuarioRepository;
import com.PortfolioAP.PortfolioAP.security.Repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    IUsuarioRepository iusuarioRepository;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
        return iusuarioRepository.findNombreUsuario(nombreUsuario);
    }

    public boolean exitsByNombreUsuario(String nombreUsuario) {
        return iusuarioRepository.exitsByNombreUsuario(nombreUsuario);
    }

    public boolean exitsByEmail(String email) {
        return iusuarioRepository.exitsByEmail(email);
    }

    public void save(Usuario usuario){
        iusuarioRepository.save(usuario);
    }

}
