package com.example.proyectobancaingenia.service;

import java.util.List;

public interface TarjetaService {

    List<String> tarjetasDeCuentasPorId (Long idCuenta);

    List<String> tarjetasPorIdUsuario (Long idUsuario);
}
