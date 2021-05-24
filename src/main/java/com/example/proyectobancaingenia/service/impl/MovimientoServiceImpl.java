package com.example.proyectobancaingenia.service.impl;

import com.example.proyectobancaingenia.dao.MovimientoDAO;
import com.example.proyectobancaingenia.model.Cuenta;
import com.example.proyectobancaingenia.model.Movimiento;
import com.example.proyectobancaingenia.model.Usuario;
import com.example.proyectobancaingenia.repository.MovimientoRepository;
import com.example.proyectobancaingenia.service.MovimientoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MovimientoServiceImpl implements MovimientoService {

    //Inyección del repositorio
    private final MovimientoRepository movimientoRepository;
    private final MovimientoDAO movimientoDAO;

    public MovimientoServiceImpl(MovimientoRepository movimientoRepository, MovimientoDAO movimientoDAO) {
        this.movimientoRepository = movimientoRepository;
        this.movimientoDAO = movimientoDAO;
    }


    /*
    Recupera Movimientos por IdUsuario (¿cambiar a idCuenta?) y los filtra por un rango de Fecha y Categoria
     */
    @Override
    public List<Movimiento> recuperaMovimientosPorIdUsuarioFiltrados(Long id, Map<String, String> customQuery) {
        if (recuperaMovimientosPorIdUsuario(id) == null){
            return null;
        }
        return movimientoDAO.movimientosFiltrados(customQuery);
    }




    @Override
    public List<Movimiento> recuperaMovimientosPorIdUsuario(Long idUsuario) {

        // Todos los movimientos de la BBDD
        List<Movimiento> listMovimientos = movimientoRepository.findAll();

        // Aquí se guardarán los movimientos del usuario con id=idUsuario
        List<Movimiento> listResultado = new ArrayList<>();

        for (int i = 0; i < listMovimientos.size(); i++) {

            Cuenta cuenta = listMovimientos.get(i).getCuenta();

            List<Usuario> listadoUsuarios = cuenta.getUsers();

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

    @Override
    public Optional<Movimiento> movimientoPorId(Long id) {

        Optional<Movimiento> movimiento = movimientoRepository.findById(id);

        return movimiento;
    }
}
