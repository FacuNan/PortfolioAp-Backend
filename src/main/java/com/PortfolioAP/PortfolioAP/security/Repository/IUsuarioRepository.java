package com.PortfolioAP.PortfolioAP.security.Repository;

import com.PortfolioAP.PortfolioAP.security.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioRepository  extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findNombreUsuario(String nombreUsuario);

    boolean exitsByNombreUsuario(String nombreUsuario);

    boolean exitsByEmail(String email);


}
