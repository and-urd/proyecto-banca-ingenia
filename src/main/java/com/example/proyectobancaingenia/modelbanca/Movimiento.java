package com.example.proyectobancaingenia.modelbanca;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="movimientos")
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String concepto;
    
    @Column(name="fecha_operacion")
    private LocalDate fechaOperacion;
    
    @Column(name="fecha_valor")
    private LocalDate fechaValor;

    private Double cantidad;

    @Column(name="saldo_actual")
    private Double saldoActual;

    @Column(name="num_tarjeta")
    private String numTarjeta;

    // todo FK Cuenta (ManyToOne)

    // todo FK Categoria (ManyToOne)

    // CONSTRUCTORES
    public Movimiento() {
    }

    public Movimiento(String concepto, LocalDate fechaOperacion, LocalDate fechaValor, Double cantidad, Double saldoActual, String numTarjeta) {
        this.concepto = concepto;
        this.fechaOperacion = fechaOperacion;
        this.fechaValor = fechaValor;
        this.cantidad = cantidad;
        this.saldoActual = saldoActual;
        this.numTarjeta = numTarjeta;
        // todo - faltan los campos del FK
    }

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public LocalDate getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(LocalDate fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public LocalDate getFechaValor() {
        return fechaValor;
    }

    public void setFechaValor(LocalDate fechaValor) {
        this.fechaValor = fechaValor;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(Double saldoActual) {
        this.saldoActual = saldoActual;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    // todo - faltan campos FK

    // METODO TOSTRING

    @Override
    public String toString() {
        return "Movimiento{" +
                "id=" + id +
                ", concepto='" + concepto + '\'' +
                ", fechaOperacion=" + fechaOperacion +
                ", fechaValor=" + fechaValor +
                ", cantidad=" + cantidad +
                ", saldoActual=" + saldoActual +
                ", numTarjeta='" + numTarjeta + '\'' +
                '}';
        // todo - faltan campos FK
    }
}
