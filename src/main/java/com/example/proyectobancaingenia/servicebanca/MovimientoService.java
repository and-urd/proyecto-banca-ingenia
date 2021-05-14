package com.example.proyectobancaingenia.servicebanca;

import com.example.proyectobancaingenia.modelbanca.Movimiento;

import java.util.List;

public interface MovimientoService {

    // Recupera movimientos de un usuario por id
    List<Movimiento> recuperaMovimientosPorIdUsuario(Long idUsuario);

    // Recupera todos los movimientos de la bbdd
    List<Movimiento> recuperaTodosMovimientos();
}
