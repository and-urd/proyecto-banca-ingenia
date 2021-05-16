package com.example.proyectobancaingenia.controllerbanca;

import com.example.proyectobancaingenia.modelbanca.Categoria;
import com.example.proyectobancaingenia.modelbanca.Cuenta;
import com.example.proyectobancaingenia.modelbanca.Movimiento;
import com.example.proyectobancaingenia.modelbanca.User;
import com.example.proyectobancaingenia.servicebanca.CuentaService;
import com.example.proyectobancaingenia.servicebanca.MovimientoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
// todo -- @CrossOrigin ........
public class MovimientoController {

    private final MovimientoService movimientoService;
    private final CuentaService cuentaService;
    public MovimientoController(MovimientoService movimientoService, CuentaService cuentaService) {
        this.movimientoService = movimientoService;
        this.cuentaService = cuentaService;
    }

//    @GetMapping("movimiento-filtrado/{idUsuario}")
//    public ResponseEntity<List<Movimiento>> movimientoFiltrado(@PathVariable Long idUsuario, @RequestParam Map<String, String> customQuery){
//        return ResponseEntity.ok(movimientoService.recuperaMovimientosPorIdUsuarioFiltrados(idUsuario, customQuery));
//    }

    @GetMapping("movimiento-filtrado/{idUsuario}")
    public ResponseEntity<List<Movimiento>> movimientoFiltrado(@PathVariable Long idUsuario, @RequestParam LocalDate fechaOperacion, @RequestParam String tipoCategoria){

        List<Movimiento>movimientosFiltrados = movimientoService.recuperaMovimientosPorIdUsuarioFiltrados(idUsuario, fechaOperacion, tipoCategoria);

        if( ! movimientosFiltrados.isEmpty()){
            return ResponseEntity.ok().body(movimientosFiltrados);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

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
    public Page<Movimiento> movimientosPorIdUsuario(@PathVariable Long idUsuario, @RequestParam Map<String, String> parametros){

        int page, size;
        // Valores por defecto para -> page , size
        // Si no está el parámetro `page` por defecto será 0
        page = parametros.containsKey("page")? Integer.parseInt(parametros.get("page")) :0;
        // Si no está el parámetro `size`, por defecto será 3
        size = parametros.containsKey("size")? Integer.parseInt(parametros.get("size")) :10;


        List<Movimiento> listado = movimientoService.recuperaMovimientosPorIdUsuario(idUsuario);




        if( ! listado.isEmpty()){

            Pageable pageable = PageRequest.of(page, size);
            return convertirListAPage(listado, pageable);
//            return ResponseEntity.ok().body(listado);
        }else{
            return null;
        }
    }

    // Método para convertir una Lista en un objeto Pageable
    public static <T> Page<T> convertirListAPage(List<T> list, Pageable pageable) {
        int inicio = (int) pageable.getOffset();
        int fin = (inicio + pageable.getPageSize()) > list.size() ? list.size() : (inicio + pageable.getPageSize());

        try {
            Page<T> page = new PageImpl<T>(list.subList(inicio, fin), pageable, list.size());
            return page;
        }catch(Exception ex){
            return null;
        }
    }








    // Recuperamos los movimientos de un usuario (idUsuario) -> filtramos por Cuenta, Tarjeta o global (todos movimientos)
    @GetMapping("movimiento-balance/{idUsuario}")
    public ResponseEntity<List<Movimiento>> movimientoBalance(@PathVariable Long idUsuario){

        // Listado completo cuentas en BBDD
        List<Cuenta> listadoCuentas = cuentaService.listadoCompletoCuentas();

        // Contendrá los movimientos de todas las cuentas del usuario, o sea, el balace GLOBAL
        List<Movimiento> listadoMovimientos = new ArrayList<>();

        // Buscamos las cuentas que pertenecen al usuario con idUsuario
        for (Cuenta cuenta: listadoCuentas) { // Para cada Cuenta del listado
            for (User user: cuenta.getUsers()   ) { // Para cada User de cuenta
                if(user.getId() == idUsuario){ // Si la cuenta pertenece al usuario idUsuario, agregamos los movimientos de esta cuenta
                    listadoMovimientos.addAll(cuenta.getMovimientos());
                }
            }
        }









        if( ! listadoCuentas.isEmpty()){
            return ResponseEntity.ok().body(listadoMovimientos);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
