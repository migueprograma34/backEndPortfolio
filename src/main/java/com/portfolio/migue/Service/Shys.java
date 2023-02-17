package com.portfolio.migue.Service;

import com.portfolio.migue.Entity.hys;
import com.portfolio.migue.Repository.Rhys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class Shys {
    @Autowired
    Rhys rhys;

    public List<hys> list(){
        return rhys.findAll();
    }

    public Optional<hys> getOne(int id){
        return rhys.findById(id);
    }

    public Optional<hys> getByNombre(String nombre){
        return rhys.findByNombre(nombre);
    }

    public void save(hys skill){
        rhys.save(skill);
    }

    public void delete(int id){
        rhys.deleteById(id);
    }

    public boolean existsById(int id){
        return rhys.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return rhys.existsByNombre(nombre);
    }
}
