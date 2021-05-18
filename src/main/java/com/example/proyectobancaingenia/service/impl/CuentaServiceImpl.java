package com.example.proyectobancaingenia.service.impl;

import com.example.proyectobancaingenia.model.Cuenta;
import com.example.proyectobancaingenia.model.Movimiento;
import com.example.proyectobancaingenia.model.Tarjeta;
import com.example.proyectobancaingenia.model.Usuario;
import com.example.proyectobancaingenia.repository.CuentaRepository;
import com.example.proyectobancaingenia.repository.MovimientoRepository;
import com.example.proyectobancaingenia.repository.TarjetaRepository;
import com.example.proyectobancaingenia.service.CuentaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CuentaServiceImpl implements CuentaService {

    // Inyección del repositorio
    private final CuentaRepository cuentaRepository;
    private final TarjetaRepository tarjetaRepository;
    private final MovimientoRepository movimientoRepository;

    public CuentaServiceImpl(CuentaRepository cuentaRepository, TarjetaRepository tarjetaRepository, MovimientoRepository movimientoRepository) {
        this.cuentaRepository = cuentaRepository;
        this.tarjetaRepository = tarjetaRepository;
        this.movimientoRepository = movimientoRepository;
    }

    // Devuelve una cuenta por ID
    @Override
    public Optional<Cuenta> recuperarCuentaPorId(Long id) {
        return cuentaRepository.findById(id);
    }


    // Devuelve las cuentas de un usuario por su id
    @Override
    public List<String> cuentasDeUsuarioPorId(Long idUsuario) {

        List<Cuenta> listadoCuentas = cuentaRepository.findAll();

        List<String> listadoResultante = new ArrayList<>();

        for (int i = 0; i < listadoCuentas.size(); i++) {

            List<Usuario> listadoUsers = listadoCuentas.get(i).getUsers();

            for (int j = 0; j < listadoUsers.size(); j++) {
                if (listadoUsers.get(j).getId() == idUsuario)
                    listadoResultante.add(listadoCuentas.get(i).getNumeroCuenta());
            }
        }

        return listadoResultante;
    }

    // Devuelve el saldo de una cuenta por numero de cuenta
    @Override
    public Double saldoDeCuenta(String numCuenta) {
        List<Cuenta> listadoCuentas = cuentaRepository.findAll();

        Double saldoResultante = 0.0;

        for (int i = 0; i < listadoCuentas.size(); i++) {

            if (listadoCuentas.get(i).getNumeroCuenta().equals(numCuenta)) {
                saldoResultante = listadoCuentas.get(i).getSaldo();
            }
//            List<User> listadoUsers = listadoCuentas.get(i).getUsers();
//
//            for (int j = 0; j < listadoUsers.size(); j++) {
//                if(listadoUsers.get(j).getId() == idUsuario)
//                    listadoResultante.add(listadoCuentas.get(i).getNumeroCuenta());
//            }
        }

        return saldoResultante;

    }


    @Override
    public List<Cuenta> listadoCompletoCuentas() {
        return cuentaRepository.findAll();
    }

    @Override
    public Cuenta crearCuenta(Cuenta cuenta) {
//        Cuenta cuentaNueva;
//
//        if (cuenta.getId() == null) {
//
//            cuentaNueva = cuentaRepository.save(cuenta);
//
//            // Tarjetas
//            List<Tarjeta> listaTarjetas = new ArrayList<>();
//
//            for (Tarjeta tarjeta : cuenta.getTarjetas()) {
//                Tarjeta tarjetaNueva = tarjeta;
//
//                tarjetaNueva.setCuenta(cuentaNueva);
//                tarjetaRepository.save(tarjetaNueva);
//                listaTarjetas.add(tarjetaNueva);
//            }
//
//            cuentaNueva.setTarjetas(listaTarjetas);
//
//
//            // Movimientos
//            List<Movimiento> listaMovimientos = new ArrayList<>();
//
//            for (Movimiento movimiento : cuenta.getMovimientos()) {
//                Movimiento movimientoNuevo = movimiento;
//
//                movimientoNuevo.setCuenta(cuentaNueva);
//                movimientoRepository.save(movimientoNuevo);
//                listaMovimientos.add(movimientoNuevo);
//            }
//
//            cuentaNueva.setMovimientos(listaMovimientos);
//
//
//            return cuentaNueva;
//
//        } else {
//            return null;
//        }

        return null;
    }
}
