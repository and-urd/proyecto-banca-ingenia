package com.example.proyectobancaingenia.modelbanca;

import javax.persistence.*;

@Entity
@Table(name="cuentas")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="numero_cuenta")
    private String numeroCuenta;

    @Column(name="tipo_cuenta")
    private String tipoCuenta;

    @Column(name="saldo")
    private Double saldo;



}
