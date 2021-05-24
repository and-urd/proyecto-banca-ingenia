package com.example.proyectobancaingenia.repository;

import com.example.proyectobancaingenia.model.Categoria;
import com.example.proyectobancaingenia.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {

    Optional<Movimiento> findById(Long id);

//    List<Movimiento> findAllByFechaOperacionAndCategoria(LocalDate fechaOperacion, String categoria);
//
//    List<Movimiento> findAllByFechaOperacionBetweenAndCuentaAndCategoria(LocalDate fechaInicio, LocalDate fechaFin, Long idCuenta, Categoria categoria);

}
