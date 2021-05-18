package com.example.proyectobancaingenia.service;

import com.example.proyectobancaingenia.model.Usuario;

public interface UserService {

    // Comprueba si un user existe por su Id
    boolean existeUserConId(Long id);

    // Crear un usuarios
    Usuario crearUsuario(Usuario usuario);
}
