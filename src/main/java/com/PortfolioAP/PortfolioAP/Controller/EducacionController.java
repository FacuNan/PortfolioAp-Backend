package com.PortfolioAP.PortfolioAP.Controller;

import com.PortfolioAP.PortfolioAP.Dto.DtoEducacion;
import com.PortfolioAP.PortfolioAP.Entity.Educacion;
import com.PortfolioAP.PortfolioAP.Security.Controller.Mensaje;
import com.PortfolioAP.PortfolioAP.Service.SEducacion;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("educacion")
@CrossOrigin(origins = "https://portfolioap-ed82a.web.app")
public class EducacionController {
    @Autowired
    SEducacion Seducacion;

    //metodo que eretorna una lista de educacion
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> lista = Seducacion.list();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("detail/{id}")
    public ResponseEntity<Educacion> detail(@PathVariable("id") int id) {
        if (!Seducacion.exitsById(id))
            return new ResponseEntity(new Mensaje("La educacion no existe"), HttpStatus.BAD_REQUEST);
        Educacion educacion = Seducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    //Metodo para crear una educacion

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoEdu) {
        if (StringUtils.isBlank(dtoEdu.getTitulo()))
            return new ResponseEntity<>(new Mensaje("El campo titulo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        Educacion educacion = new Educacion(dtoEdu.getTitulo(), dtoEdu.getInstitucion(), dtoEdu.getDescripcion(), dtoEdu.getFechaInicio(), dtoEdu.getFechaTerminacion());

        if (Seducacion.exitsByNombreEdu(dtoEdu.getTitulo()))
            return new ResponseEntity<>(new Mensaje("Esa Educacion ya existe"), HttpStatus.BAD_REQUEST);
        Seducacion.save(educacion);
        return new ResponseEntity<>(new Mensaje("Educacion creada correctamente"), HttpStatus.OK);
    }


    //Metodo para editar una educacion

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoEdu) {
        if (StringUtils.isBlank(dtoEdu.getTitulo()))
            return new ResponseEntity<>(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);

        //Verificacion del id
        if (!Seducacion.exitsById(id))
            return new ResponseEntity<>(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);

        if (Seducacion.exitsByNombreEdu(dtoEdu.getTitulo()) && Seducacion.getNombreEducacion(dtoEdu.getTitulo()).get().getId() != id)

            return new ResponseEntity<>(new Mensaje("Esa educacion no existe"), HttpStatus.BAD_REQUEST);

        Educacion educacion = Seducacion.getOne(id).get();
        educacion.setTitulo(dtoEdu.getTitulo());
        educacion.setInstitucion(dtoEdu.getInstitucion());
        educacion.setDescripcion(dtoEdu.getDescripcion());
        educacion.setFechaInicio(dtoEdu.getFechaInicio());
        educacion.setFechaTerminacion(dtoEdu.getFechaTerminacion());


        Seducacion.save(educacion);

        return new ResponseEntity<>(new Mensaje("La educacion fue actualizada exitosamente"), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!Seducacion.exitsById(id))
            return new ResponseEntity<>(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);

        Seducacion.delete(id);
        return new ResponseEntity<>(new Mensaje("La educacion fue eliminada existosamente"), HttpStatus.OK);
    }


}
