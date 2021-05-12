package com.example.proyectobancaingenia.repository;

import com.example.proyectobancaingenia.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
