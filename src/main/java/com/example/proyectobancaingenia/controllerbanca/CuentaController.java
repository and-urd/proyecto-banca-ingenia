package com.example.proyectobancaingenia.controllerbanca;

import com.example.proyectobancaingenia.modelbanca.Cuenta;
import com.example.proyectobancaingenia.modelbanca.User;
import com.example.proyectobancaingenia.servicebanca.CuentaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @GetMapping("/cuenta-numeroscuenta/{id}")
    public ResponseEntity<List<String>> cuentasDeUsuarioPorId(@PathVariable Long id){
        List<Cuenta> listadoCuentas = cuentaService.cuentasDeUsuarioPorId(id);

        List<String> listadoResultante = new ArrayList<>();

        for (int i = 0; i < listadoCuentas.size(); i++) {

            List<User> listadoUsers = listadoCuentas.get(i).getUsers();

            for (int j = 0; j < listadoUsers.size(); j++) {
                if(listadoUsers.get(j).getId() == id)
                    listadoResultante.add(listadoCuentas.get(i).getNumeroCuenta());
            }
        }


        if(listadoCuentas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return ResponseEntity.ok().body(listadoResultante);
        }



    }

}
