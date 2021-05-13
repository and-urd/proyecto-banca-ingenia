package com.example.proyectobancaingenia.modelbanca;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_categoria")
    private String tipoCategoria;

//   @OneToMany
//   private List<Movimiento> movimientos = new ArrayList<>();

    public Categoria() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoCategoria() {
        return tipoCategoria;
    }

    public void setTipoCategoria(String tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", tipoCategoria='" + tipoCategoria + '\'' +
                '}';
    }
}
