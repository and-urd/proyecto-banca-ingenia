package com.example.proyectobancaingenia.service;

import com.example.proyectobancaingenia.model.Movimiento;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface MovimientoService {

    List<Movimiento>recuperaMovimientosPorIdUsuarioFiltrados(Long id, Map<String, String> customQuery);

    // Recupera movimientos de un usuario por id
    List<Movimiento> recuperaMovimientosPorIdUsuario(Long idCuenta);

    // Recupera todos los movimientos de la bbdd
    List<Movimiento> recuperaTodosMovimientos();

    // Recupera movimiento por su id
    Optional<Movimiento> movimientoPorId(Long id);
}
