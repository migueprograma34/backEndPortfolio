package com.portfolio.migue.Controller;

import com.portfolio.migue.DTO.dtoExp;
import com.portfolio.migue.Entity.Exp;
import com.portfolio.migue.Service.SExp;
import com.portfolio.migue.Security.Controller.Mensaje;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/explab")
@CrossOrigin(origins = "http://localhost:4200")
public class CExp {
    @Autowired
    SExp sExp;

    @GetMapping("/lista")
    public ResponseEntity<List<Exp>> list(){
        List<Exp> list = sExp.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Exp> getById(@PathVariable("id") int id){
        if(!sExp.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Exp exp = sExp.getOne(id).get();
        return new ResponseEntity(exp, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sExp.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sExp.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExp dtoexp){
        if(StringUtils.isBlank(dtoexp.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sExp.existsByNombreE(dtoexp.getNombreE()))
            return new ResponseEntity(new Mensaje("Esa exp existe"), HttpStatus.BAD_REQUEST);

        Exp exp = new Exp(dtoexp.getNombreE(), dtoexp.getDescripcionE());
        sExp.save(exp);

        return new ResponseEntity(new Mensaje("Exp agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExp dtoexp){
        if(!sExp.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        if(sExp.existsByNombreE(dtoexp.getNombreE()) && sExp.getByNombreE(dtoexp.getNombreE()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa exp ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoexp.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        Exp exp = sExp.getOne(id).get();
        exp.setNombreE(dtoexp.getNombreE());
        exp.setDescripcionE((dtoexp.getDescripcionE()));

        sExp.save(exp);
        return new ResponseEntity(new Mensaje("Exp actualizada"), HttpStatus.OK);

    }
}
