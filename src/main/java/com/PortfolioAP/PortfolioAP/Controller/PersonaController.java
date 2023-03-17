package com.PortfolioAP.PortfolioAP.Controller;

import com.PortfolioAP.PortfolioAP.Dto.DtoPersona;
import com.PortfolioAP.PortfolioAP.Entity.Persona;
import com.PortfolioAP.PortfolioAP.Interface.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"https://portfolioap-ed82a.web.app","http://localhost:4200"})
public class PersonaController {

    @Autowired
    IPersonaService ipersonaService;

    @GetMapping("personas/traer")
    public List<Persona> getPersona() {
        return ipersonaService.getPersona();
    }

    @GetMapping("personas/detail/{id}")
    public ResponseEntity<Persona> detail(@PathVariable("id") int id) {
        Persona persona = ipersonaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    @PreAuthorize("HasRole('ADMIN')")
    @PostMapping("personas/crear")
    public String createPersona(@RequestBody Persona persona) {
        ipersonaService.savePersona(persona);
        return "La persona se creo correctamente";
    }

    @DeleteMapping("/personas/traer/{id}")

    public String deletePersona(@PathVariable int id) {
        ipersonaService.deletePersona(id);
        return "La persona se borro exitosamente";
    }

    @PutMapping("personas/update/{id}")

    public Persona editPersona(@PathVariable int  id, @RequestBody DtoPersona dtoPersona) {

        Persona persona = ipersonaService.findPersona(id);
        persona.setNombre(dtoPersona.getNombre());
        persona.setApellido(dtoPersona.getApellido());
        persona.setImg(dtoPersona.getImg());
        persona.setBiografia(dtoPersona.getBiografia());
        ipersonaService.savePersona(persona);

        return persona;

    }

    @GetMapping("/personas/traer/perfil")
    public Persona findPersona() {
        return ipersonaService.findPersona((int) 1);
    }

}
