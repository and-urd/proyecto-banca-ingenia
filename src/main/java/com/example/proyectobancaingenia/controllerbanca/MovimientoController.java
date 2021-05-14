package com.example.proyectobancaingenia.controllerbanca;

import com.example.proyectobancaingenia.modelbanca.Movimiento;
import com.example.proyectobancaingenia.servicebanca.MovimientoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
// todo -- @CrossOrigin ........
public class MovimientoController {

    private final MovimientoService movimientoService;
    public MovimientoController(MovimientoService movimientoService) {
        this.movimientoService = movimientoService;
    }

    // Devuelve todos los movimientos de la bbdd
    @GetMapping("/movimientos")
    public ResponseEntity<List<Movimiento>> recuperaTodosMovimientos(){
        List<Movimiento> listado = movimientoService.recuperaTodosMovimientos();
        if( ! listado.isEmpty()){
            return ResponseEntity.ok().body(listado);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Devuelve todos los movimientos de un usuario por idUsuario
//    @GetMapping("/movimientos-usuario/{idUsuario}")
//    public ResponseEntity<List<Movimiento>> movimientosPorIdUsuario(@PathVariable Long idUsuario){
//        List<Movimiento> listado = movimientoService.recuperaMovimientosPorIdUsuario(idUsuario);
//        if( ! listado.isEmpty()){
//            return ResponseEntity.ok().body(listado);
//        }else{
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @GetMapping("/movimientos-usuario/{idUsuario}")
    public ResponseEntity<List<Movimiento>> movimientosPorIdUsuario(@PathVariable Long idUsuario){
        List<Movimiento> listado = movimientoService.recuperaMovimientosPorIdUsuario(idUsuario);
        if( ! listado.isEmpty()){
            return ResponseEntity.ok().body(listado);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
