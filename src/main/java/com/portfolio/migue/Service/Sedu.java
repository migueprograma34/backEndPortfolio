package com.portfolio.migue.Service;

import com.portfolio.migue.Entity.Edu;
import com.portfolio.migue.Repository.REdu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class Sedu {
    @Autowired
    REdu rEdu;

    public List<Edu> list(){
        return rEdu.findAll();
    }

    public Optional<Edu> getOne(int id){
        return rEdu.findById(id);
    }

    public Optional<Edu> getByNmbreE(String nombreE){
        return rEdu.findByNombreE(nombreE);
    }

    public void save(Edu edu){
        rEdu.save(edu);
    }

    public void delete(int id){
        rEdu.deleteById(id);
    }

    public boolean existsById(int id){
        return rEdu.existsById(id);
    }

    public boolean existsByNombreE(String nombreE){
        return rEdu.existsByNombreE(nombreE);
    }
}
