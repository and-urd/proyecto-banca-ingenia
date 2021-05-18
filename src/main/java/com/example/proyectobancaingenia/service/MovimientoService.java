package com.example.proyectobancaingenia.service;

import com.example.proyectobancaingenia.model.Movimiento;

import java.util.List;
import java.util.Optional;

public interface MovimientoService {

//    List<Movimiento>recuperaMovimientosPorIdUsuarioFiltrados(Long id, Map<String, String> customQuery);
//    List<Movimiento> recuperaMovimientosPorIdUsuarioFiltrados(Long id, LocalDate fechaOperacion, String categoria);

    // Recupera movimientos de un usuario por id
    List<Movimiento> recuperaMovimientosPorIdUsuario(Long idUsuario);

    // Recupera todos los movimientos de la bbdd
    List<Movimiento> recuperaTodosMovimientos();

    // Recupera movimiento por su id
    Optional<Movimiento> movimientoPorId(Long id);
}
