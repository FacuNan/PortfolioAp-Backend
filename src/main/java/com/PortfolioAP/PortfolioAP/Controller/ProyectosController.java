package com.PortfolioAP.PortfolioAP.Controller;

import com.PortfolioAP.PortfolioAP.Dto.DtoProyectos;
import com.PortfolioAP.PortfolioAP.Entity.Proyectos;
import com.PortfolioAP.PortfolioAP.Security.Controller.Mensaje;
import com.PortfolioAP.PortfolioAP.Service.SProyectos;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("proyectos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectosController {
    @Autowired
    SProyectos sProyectos;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list() {
        List<Proyectos> lista = sProyectos.list();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> detail(@PathVariable("id") int id) {
        if (!sProyectos.exitsById(id))
            return new ResponseEntity(new Mensaje("El proyecto no existe"), HttpStatus.BAD_REQUEST);

        Proyectos proyectos = sProyectos.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProyectos dtoProyectos) {
        if (StringUtils.isBlank(dtoProyectos.getNombreProyecto()))
            return new ResponseEntity<>(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);

        if (sProyectos.exitsByNombre(dtoProyectos.getNombreProyecto()))
            return new ResponseEntity<>(new Mensaje("El nombre del proyecto ya existe"), HttpStatus.BAD_REQUEST);

        Proyectos proyectos = new Proyectos(dtoProyectos.getNombreProyecto(), dtoProyectos.getImg(), dtoProyectos.getDescripcion());

        sProyectos.save(proyectos);

        return new ResponseEntity<>(new Mensaje("El proyecto se ha guardado exitosamente"), HttpStatus.OK);


    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyectos dtoProyectos) {
        if (StringUtils.isBlank(dtoProyectos.getImg()))
            return new ResponseEntity<>(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);

        if (sProyectos.exitsByNombre(dtoProyectos.getNombreProyecto()) && sProyectos.getNombreProyecto(dtoProyectos.getNombreProyecto()).get().getId() != id)
            return new ResponseEntity<>(new Mensaje("El proyecto ya existe"), HttpStatus.BAD_REQUEST);

        if (!sProyectos.exitsById(id))
            return new ResponseEntity<>(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);

        Proyectos proyectos = sProyectos.getOne(id).get();
        proyectos.setNombreProyecto(dtoProyectos.getNombreProyecto());
        proyectos.setImg(dtoProyectos.getImg());
        proyectos.setDescripcion(dtoProyectos.getDescripcion());

        sProyectos.save(proyectos);

        return new ResponseEntity<>(new Mensaje("El proyecto fue actualizado correctamente"), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sProyectos.exitsById(id))
            return new ResponseEntity<>(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        sProyectos.delete(id);
        return new ResponseEntity<>(new Mensaje("El proyecto ha sido eliminado"), HttpStatus.OK);


    }

}

