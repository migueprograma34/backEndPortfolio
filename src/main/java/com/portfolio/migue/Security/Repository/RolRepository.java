package com.portfolio.migue.Security.Repository;

import com.portfolio.migue.Security.Entity.Rol;
import com.portfolio.migue.Security.Enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol,Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
