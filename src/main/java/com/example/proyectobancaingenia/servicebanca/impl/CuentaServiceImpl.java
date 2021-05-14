package com.example.proyectobancaingenia.servicebanca.impl;

import com.example.proyectobancaingenia.modelbanca.Cuenta;
import com.example.proyectobancaingenia.repositorybanca.CuentaRepository;
import com.example.proyectobancaingenia.servicebanca.CuentaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaServiceImpl implements CuentaService {

    // Inyección del repositorio
    private final CuentaRepository cuentaRepository;
    public CuentaServiceImpl(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public List<Cuenta> cuentasDeUsuarioPorId(Long idUsuario) {

        // Recupero todas las cuentas de la BBDD
        List<Cuenta> listadoCuentas = cuentaRepository.findAll();

        return listadoCuentas;
    }
}
