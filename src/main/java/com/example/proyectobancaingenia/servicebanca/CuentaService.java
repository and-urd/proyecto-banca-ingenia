package com.example.proyectobancaingenia.servicebanca;

import com.example.proyectobancaingenia.modelbanca.Cuenta;

import java.util.List;

public interface CuentaService {

    // Recupera las cuentas asociadas(listado String) a un usuario por su id
    List<String> cuentasDeUsuarioPorId(Long idUsuario);




//    // Recupera todas las cuentas de la bbdd
//    List<Cuenta> cuentasFindAll();


}
