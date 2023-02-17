package com.portfolio.migue.Repository;

import com.portfolio.migue.Entity.Edu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface REdu extends JpaRepository<Edu, Integer>{
    public Optional<Edu> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
}
