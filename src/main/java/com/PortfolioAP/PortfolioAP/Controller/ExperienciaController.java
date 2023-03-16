package com.PortfolioAP.PortfolioAP.Controller;

import com.PortfolioAP.PortfolioAP.Dto.DtoExperiencia;
import com.PortfolioAP.PortfolioAP.Entity.Experiencia;
import com.PortfolioAP.PortfolioAP.Security.Controller.Mensaje;
import com.PortfolioAP.PortfolioAP.Service.SExperiencia;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("experienciaLaboral")
@CrossOrigin(origins = {"https://portfolioap-ed82a.firebaseapp.com","http://localhost:4200"})
public class ExperienciaController {

    @Autowired
    SExperiencia Sexperiencia;


    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoExp) {
        if (StringUtils.isBlank(dtoExp.getNombreE()))
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);


        if (Sexperiencia.exitsBynombreExp(dtoExp.getDescripcion()))
            return new ResponseEntity<>(new Mensaje("La descripcion es obligatoria"), HttpStatus.BAD_REQUEST);

        Experiencia experiencia = new Experiencia(dtoExp.getNombreE(), dtoExp.getDescripcion(), dtoExp.getInstitucion(), dtoExp.getFechaInicio(), dtoExp.getFechaTerminacion());

        Sexperiencia.save(experiencia);
        return new ResponseEntity<>(new Mensaje("Experiencia agregada"), HttpStatus.OK);

    }

    @GetMapping("detail/{id}")
    public ResponseEntity<Experiencia> detail(@PathVariable("id") int id) {
        if (!Sexperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("La experiencia no existe"), HttpStatus.BAD_REQUEST);

        Experiencia experiencia = Sexperiencia.getOne(id).get();
        return new ResponseEntity<>(experiencia, HttpStatus.OK);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> lista = Sexperiencia.list();
        return new ResponseEntity(lista, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoexp) {
        //Validamos si existe el ID
        if (!Sexperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if (Sexperiencia.exitsBynombreExp(dtoexp.getNombreE()) && Sexperiencia.getNombre(dtoexp.getNombreE()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if (StringUtils.isBlank(dtoexp.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        Experiencia experiencia = Sexperiencia.getOne(id).get();
        experiencia.setNombreE(dtoexp.getNombreE());
        experiencia.setInstitucion(dtoexp.getInstitucion());
        experiencia.setFechaInicio(dtoexp.getFechaInicio());
        experiencia.setFechaTerminacion(dtoexp.getFechaTerminacion());


        Sexperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!Sexperiencia.existsById(id))
            return new ResponseEntity<>(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        Sexperiencia.delete(id);
        return new ResponseEntity<>(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }


}
