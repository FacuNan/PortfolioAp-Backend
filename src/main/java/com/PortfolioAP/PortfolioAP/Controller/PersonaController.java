package com.PortfolioAP.PortfolioAP.Controller;

import com.PortfolioAP.PortfolioAP.Entity.Persona;
import com.PortfolioAP.PortfolioAP.Interface.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    IPersonaService ipersonaService;

    @GetMapping("personas/traer")
    public List<Persona> getPersona() {
        return ipersonaService.getPersona();
    }

    @PostMapping("personas/crear")
    public String createPersona(@RequestBody Persona persona) {
        ipersonaService.savePersona(persona);
        return "La persona se creo correctamente";
    }

    @DeleteMapping("/personas/traer/{id}")

    public String deletePersona(@PathVariable Long id) {
        ipersonaService.deletePersona(id);
        return "La persona se borro exitosamente";
    }

    @PutMapping("personas/editar/{id}")

    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido,
                               @RequestParam("img") String nuevaImg) {

        Persona persona = ipersonaService.findPersona(id);
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevaImg);
        ipersonaService.savePersona(persona);

        return persona;

    }

}
