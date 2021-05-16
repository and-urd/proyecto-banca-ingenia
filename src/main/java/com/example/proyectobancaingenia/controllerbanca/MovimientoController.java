package com.example.proyectobancaingenia.controllerbanca;

import com.example.proyectobancaingenia.modelbanca.Movimiento;
import com.example.proyectobancaingenia.servicebanca.MovimientoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

}
