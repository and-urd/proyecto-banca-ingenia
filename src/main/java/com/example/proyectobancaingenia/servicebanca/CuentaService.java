package com.example.proyectobancaingenia.servicebanca;

import com.example.proyectobancaingenia.modelbanca.Cuenta;

import java.util.List;

public interface CuentaService {

    // Recupera las cuentas asociadas(listado String) a un usuario por su id
    List<String> cuentasDeUsuarioPorId(Long idUsuario);




    // Recupera el saldo de una cuenta por su numero de cuenta (String)
    Double saldoDeCuenta(String numCuenta);


}
