package com.example.proyectobancaingenia.servicebanca.impl;

import com.example.proyectobancaingenia.modelbanca.Cuenta;
import com.example.proyectobancaingenia.modelbanca.User;
import com.example.proyectobancaingenia.repositorybanca.CuentaRepository;
import com.example.proyectobancaingenia.servicebanca.CuentaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CuentaServiceImpl implements CuentaService {

    // Inyección del repositorio
    private final CuentaRepository cuentaRepository;
    public CuentaServiceImpl(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }





    // Devuelve las cuentas de un usuario por su id
    @Override
    public List<String> cuentasDeUsuarioPorId(Long idUsuario) {

        List<Cuenta> listadoCuentas = cuentaRepository.findAll();

        List<String> listadoResultante = new ArrayList<>();

        for (int i = 0; i < listadoCuentas.size(); i++) {

            List<User> listadoUsers = listadoCuentas.get(i).getUsers();

            for (int j = 0; j < listadoUsers.size(); j++) {
                if(listadoUsers.get(j).getId() == idUsuario)
                    listadoResultante.add(listadoCuentas.get(i).getNumeroCuenta());
            }
        }

        return listadoResultante;
    }







//    @Override
//    public List<Cuenta> cuentasFindAll() {
//        return
//    }
}
