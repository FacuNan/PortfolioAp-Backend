package com.PortfolioAP.PortfolioAP.Controller;

import com.PortfolioAP.PortfolioAP.Dto.DtoSkills;
import com.PortfolioAP.PortfolioAP.Entity.Proyectos;
import com.PortfolioAP.PortfolioAP.Entity.Skills;
import com.PortfolioAP.PortfolioAP.Security.Controller.Mensaje;
import com.PortfolioAP.PortfolioAP.Service.SSkills;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("skills")
@CrossOrigin(origins = {"https://portfolioap-ed82a.web.app/","http://localhost:4200"})
public class SkillsController {
    @Autowired
    SSkills sSkils;

    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list() {
        List<Skills> lista = sSkils.list();

        return new ResponseEntity(lista, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> detail(@PathVariable("id") int id) {
        if (!sSkils.existById(id))
            return new ResponseEntity(new Mensaje("El Skill no existe"), HttpStatus.BAD_REQUEST);

        Skills skills = sSkils.getOne(id).get();

        return new ResponseEntity(skills, HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoSkills dtoSkills) {
        if (StringUtils.isBlank(dtoSkills.getNombre()))
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);

        if (sSkils.existsBynombre(dtoSkills.getNombre()))
            return new ResponseEntity(new Mensaje("El Skill ya existe"), HttpStatus.BAD_REQUEST);

        Skills skills = new Skills(dtoSkills.getNombre(), dtoSkills.getPorcentaje(), dtoSkills.getRadius(), dtoSkills.getColorExterno(), dtoSkills.getColorInterno());

        sSkils.save(skills);

        return new ResponseEntity(new Mensaje("El skill fue creado con exito"), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoSkills dtoSkills) {
        if (!sSkils.existById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        if (sSkils.existsBynombre(dtoSkills.getNombre()) && sSkils.getByNombre(dtoSkills.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("El skill ya existe"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(dtoSkills.getNombre()))
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        Skills skills = sSkils.getOne(id).get();

        skills.setNombre(dtoSkills.getNombre());
        skills.setPorcentaje(dtoSkills.getPorcentaje());
        skills.setRadius(dtoSkills.getRadius());
        skills.setColorExterno(dtoSkills.getColorExterno());
        skills.setColorInterno(dtoSkills.getColorInterno());

        sSkils.save(skills);

        return new ResponseEntity(new Mensaje("El Skill fue actualizado con exito"), HttpStatus.OK);

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sSkils.existById(id))
            return new ResponseEntity(new Mensaje("El skill no existe"), HttpStatus.BAD_REQUEST);
        sSkils.delete(id);
        return new ResponseEntity(new Mensaje("El Skill se ha eliminado con exito"), HttpStatus.OK);

    }
}
