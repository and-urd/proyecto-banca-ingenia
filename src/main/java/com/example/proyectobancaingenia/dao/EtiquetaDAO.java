package com.example.proyectobancaingenia.dao;

import com.example.proyectobancaingenia.model.Etiqueta;

import java.util.List;

public interface EtiquetaDAO {

    List<Etiqueta> encontrarPorNombre(String nombre);
}
