package com.PortfolioAP.PortfolioAP.Controller;

import com.PortfolioAP.PortfolioAP.Dto.DtoExperiencia;
import com.PortfolioAP.PortfolioAP.Entity.Experiencia;
import com.PortfolioAP.PortfolioAP.Security.Controller.Mensaje;
import com.PortfolioAP.PortfolioAP.Service.SExperiencia;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("experienciaLaboral")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaController {

    @Autowired
    SExperiencia Sexperiencia;



    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoExp) {
        if (StringUtils.isBlank(dtoExp.getNombreE()))
            return new ResponseEntity<>(new Mensaje("Elnombre es obligatorio"), HttpStatus.BAD_REQUEST);


        if (Sexperiencia.exitsBynombreExp(dtoExp.getDescripcion()))
            return new ResponseEntity<>(new Mensaje("La descripcion es obligatoria"), HttpStatus.BAD_REQUEST);

        Experiencia experiencia = new Experiencia(dtoExp.getNombreE(), dtoExp.getDescripcion(), dtoExp.getInstitucion(), dtoExp.getFechaInicio(), dtoExp.getFechaTerminacion());

        Sexperiencia.save(experiencia);
        return new ResponseEntity<>(new Mensaje("Experiencia agregada"), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoExperiencia) {
        //Se valida si existe el id

        if (!Sexperiencia.existsById(id))
            return new ResponseEntity<>(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);

        if (Sexperiencia.exitsBynombreExp(dtoExperiencia.getNombreE()) && Sexperiencia.getNombre(dtoExperiencia.getNombreE()).get().getId() != id)
            return new ResponseEntity<>(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);

        if (StringUtils.isBlank(dtoExperiencia.getNombreE()))
            return new ResponseEntity<>(new Mensaje("El campo nombre no puede estar vacio"), HttpStatus.BAD_REQUEST);

        Experiencia experiencia = Sexperiencia.getOne(id).get();
        experiencia.setPuesto(dtoExperiencia.getNombreE());
        experiencia.setDescripcion(dtoExperiencia.getDescripcion());
        experiencia.setInstitucion(dtoExperiencia.getInstitucion());
        experiencia.setFechaInicio(dtoExperiencia.getFechaInicio());
        experiencia.setFechaTerminacion(dtoExperiencia.getFechaTerminacion());

        Sexperiencia.save(experiencia);
        return new ResponseEntity<>(new Mensaje("La experiencia fue actualizada exitosamente"), HttpStatus.OK);

    }


    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!Sexperiencia.existsById(id))
            return new ResponseEntity<>(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        Sexperiencia.delete(id);
        return new ResponseEntity<>(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }


}
