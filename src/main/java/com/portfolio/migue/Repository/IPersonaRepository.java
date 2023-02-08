package com.portfolio.migue.Repository;

import com.portfolio.migue.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository< Persona,Long>{
}
