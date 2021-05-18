package com.example.proyectobancaingenia.controller;

import com.example.proyectobancaingenia.service.TarjetaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
// todo -- @CrossOrigin......
public class TarjetaController {

    private final TarjetaService tarjetaService;

    public TarjetaController(TarjetaService tarjetaService) {
        this.tarjetaService = tarjetaService;
    }

    @GetMapping("/tarjeta/{id}")
    public ResponseEntity<List<String>> getTarjetaByIdCuenta(@PathVariable Long id) {
        List<String> numTarjeta = tarjetaService.tarjetasDeCuentasPorId(id);
        if (numTarjeta != null){
            return ResponseEntity.ok().body(numTarjeta);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
