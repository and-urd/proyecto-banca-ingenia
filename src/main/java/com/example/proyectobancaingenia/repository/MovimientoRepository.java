package com.example.proyectobancaingenia.repository;

import com.example.proyectobancaingenia.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {

    Optional<Movimiento> findById(Long id);

}
