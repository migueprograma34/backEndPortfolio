package com.portfolio.migue.Controller;

import com.portfolio.migue.DTO.dtoEdu;
import com.portfolio.migue.Entity.Edu;
import com.portfolio.migue.Service.Sedu;
import com.portfolio.migue.Security.Controller.Mensaje;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")
public class CEdu {
    @Autowired
    Sedu sedu;

    @GetMapping("/lista")
    public ResponseEntity<List<Edu>> list(){
        List<Edu> list = sedu.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Edu> getById(@PathVariable("id")int id){
        if(!sedu.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }

        Edu edu = sedu.getOne(id).get();
        return new ResponseEntity(edu, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sedu.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sedu.delete(id);
        return new ResponseEntity(new Mensaje("Edu eliminada"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEdu dtoeducacion){
        if(StringUtils.isBlank(dtoeducacion.getNombreE())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sedu.existsByNombreE(dtoeducacion.getNombreE())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        Edu edu = new Edu(
                dtoeducacion.getNombreE(), dtoeducacion.getDescripcionE()
        );
        sedu.save(edu);
        return new ResponseEntity(new Mensaje("Edu creada"), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEdu dtoeducacion){
        if(!sedu.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(sedu.existsByNombreE(dtoeducacion.getNombreE()) && sedu.getByNmbreE(dtoeducacion.getNombreE()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoeducacion.getNombreE())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        Edu edu = sedu.getOne(id).get();

        edu.setNombreE(dtoeducacion.getNombreE());
        edu.setDescripcionE(dtoeducacion.getDescripcionE());

        sedu.save(edu);

        return new ResponseEntity(new Mensaje("Edu actualizada"), HttpStatus.OK);
    }
}
