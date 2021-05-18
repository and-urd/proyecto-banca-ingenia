package com.example.proyectobancaingenia.repository;

import com.example.proyectobancaingenia.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
