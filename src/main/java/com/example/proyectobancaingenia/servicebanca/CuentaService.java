package com.example.proyectobancaingenia.servicebanca;

import com.example.proyectobancaingenia.modelbanca.Cuenta;

import java.util.List;

public interface CuentaService {

    // Recupera las cuentas asociadas a un usuario por su id
    List<Cuenta> cuentasDeUsuarioPorId(Long idUsuario);


}
