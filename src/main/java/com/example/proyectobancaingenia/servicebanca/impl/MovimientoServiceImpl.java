package com.example.proyectobancaingenia.servicebanca.impl;

import com.example.proyectobancaingenia.modelbanca.Cuenta;
import com.example.proyectobancaingenia.modelbanca.Movimiento;
import com.example.proyectobancaingenia.modelbanca.User;
import com.example.proyectobancaingenia.repositorybanca.MovimientoRepository;
import com.example.proyectobancaingenia.servicebanca.MovimientoService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovimientoServiceImpl implements MovimientoService {

    //Inyección del repositorio
    private final MovimientoRepository movimientoRepository;
    public MovimientoServiceImpl(MovimientoRepository movimientoRepository) {
        this.movimientoRepository = movimientoRepository;
    }


    @Override
    public List<Movimiento> recuperaMovimientosPorIdUsuario(Long idUsuario) {

        // Todos los movimientos de la BBDD
        List<Movimiento> listMovimientos = movimientoRepository.findAll();

        // Aquí se guardarán los movimientos del usuario con id=idUsuario
        List<Movimiento> listResultado = new ArrayList<>();

        for (int i = 0; i < listMovimientos.size(); i++) {

            Cuenta cuenta = listMovimientos.get(i).getCuenta();

            List<User> listadoUsuarios = cuenta.getUsers();

            for (int j = 0; j < listadoUsuarios.size(); j++) {
                if(listadoUsuarios.get(j).getId() == idUsuario)
                    listResultado.add(listMovimientos.get(i));
            }

        }
        return listResultado;
    }

    @Override
    public List<Movimiento> recuperaTodosMovimientos() {
        return movimientoRepository.findAll();
    }
}
