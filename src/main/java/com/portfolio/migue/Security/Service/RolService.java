package com.portfolio.migue.Security.Service;

import com.portfolio.migue.Security.Entity.Rol;
import com.portfolio.migue.Security.Enums.RolNombre;
import com.portfolio.migue.Security.Repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RolService {
    @Autowired
    RolRepository rolRepository;
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }
 public void save(Rol rol){
        rolRepository.save(rol);
 }
}
