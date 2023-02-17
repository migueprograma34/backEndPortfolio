package com.portfolio.migue.Repository;

import com.portfolio.migue.Entity.Exp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RExp extends JpaRepository<Exp, Integer>{
        public Optional<Exp> findByNombreE(String nombreE);
        public boolean existsByNombreE(String nombreE);
}

