package com.PortfolioAP.PortfolioAP.security.Controller;

import com.PortfolioAP.PortfolioAP.security.DTO.JwtDto;
import com.PortfolioAP.PortfolioAP.security.DTO.LoginUsuario;
import com.PortfolioAP.PortfolioAP.security.DTO.NuevoUsuario;
import com.PortfolioAP.PortfolioAP.security.Entity.Rol;
import com.PortfolioAP.PortfolioAP.security.Entity.Usuario;
import com.PortfolioAP.PortfolioAP.security.JWT.JwtProvider;
import com.PortfolioAP.PortfolioAP.security.Service.RolService;
import com.PortfolioAP.PortfolioAP.security.Service.UsuarioService;
import com.PortfolioAP.PortfolioAP.security.enums.RolNombre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin()


public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/nuevo")

    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevousuario, BindingResult bindingresult) {
        if (bindingresult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal puestos"), HttpStatus.BAD_REQUEST);


        if (usuarioService.exitsByNombreUsuario(nuevousuario.getNombreUsuario()))
            return new ResponseEntity(new Mensaje("El usuario ya existe"), HttpStatus.BAD_REQUEST);

        if (usuarioService.exitsByEmail(nuevousuario.getEmail()))
            return new ResponseEntity(new Mensaje("El email ya existe"), HttpStatus.BAD_REQUEST);

        Usuario usuario = new Usuario(nuevousuario.getNombre(), nuevousuario.getNombreUsuario(), nuevousuario.getEmail(), passwordEncoder.encode(nuevousuario.getPassword()));


        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());


        if (nuevousuario.getRoles().contains("admin")) roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        usuarioService.save(usuario);


        return new ResponseEntity(new Mensaje("Usuario Guardado"), HttpStatus.CREATED);

    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal puestos"), HttpStatus.BAD_REQUEST);

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateToken(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());

        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }

}

