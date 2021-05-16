package com.example.proyectobancaingenia.servicebanca;

import com.example.proyectobancaingenia.modelbanca.Movimiento;

import java.util.List;
import java.util.Optional;

public interface MovimientoService {

    // Recupera movimientos de un usuario por id
    List<Movimiento> recuperaMovimientosPorIdUsuario(Long idUsuario);

    // Recupera todos los movimientos de la bbdd
    List<Movimiento> recuperaTodosMovimientos();

    // Recupera movimiento por su id
    Optional<Movimiento> movimientoPorId(Long id);
}
