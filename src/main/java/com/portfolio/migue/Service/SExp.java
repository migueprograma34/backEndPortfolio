package com.portfolio.migue.Service;

import com.portfolio.migue.Entity.Exp;
import com.portfolio.migue.Repository.RExp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class SExp {
    @Autowired
    RExp rExp;

    public List<Exp> list(){
        return rExp.findAll();
    }

    public Optional<Exp> getOne(int id){
        return rExp.findById(id);
    }

    public Optional<Exp> getByNombreE(String nombreE){
        return rExp.findByNombreE(nombreE);
    }

    public void save(Exp expe){
        rExp.save(expe);
    }

    public void delete(int id){
        rExp.deleteById(id);
    }

    public boolean existsById(int id){
        return rExp.existsById(id);
    }

    public boolean existsByNombreE(String nombreE){
        return rExp.existsByNombreE(nombreE);
    }
}
