package com.example.proyectobancaingenia.controllerbanca;

import com.example.proyectobancaingenia.modelbanca.Cuenta;
import com.example.proyectobancaingenia.servicebanca.CuentaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
// todo -- @CrossOrigin......
public class CuentaController {
    private final Logger  log = LoggerFactory.getLogger (CuentaController.class);

    // Inyecto cuentaService
    private final CuentaService cuentaService;
    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    // Recupera cuentas de un usuario por su id
    @GetMapping("/cuenta-listado/{id}")
    public ResponseEntity<List<Cuenta>> cuentasDeUsuarioPorId(@PathVariable Long id){
        List<Cuenta> listado = cuentaService.cuentasDeUsuarioPorId(id);

        if(listado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return ResponseEntity.ok().body(listado);
        }



    }

}
