package com.example.proyectobancaingenia.repositorybanca;

import com.example.proyectobancaingenia.modelbanca.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
}

