package com.example.proyectobancaingenia.dao;

import com.example.proyectobancaingenia.model.Movimiento;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MovimientoDAO {

    List<Movimiento> movimientosFiltrados(Map<String, String> customQuery);

}
