package com.example.proyectobancaingenia.modelbanca;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany
    @JoinTable(
            name = "cuentas_users",
            joinColumns = {@JoinColumn(name="cuenta_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="user_id", referencedColumnName = "id")}
    )
    private List<User> users = new ArrayList<>();

//   @OneToMany
//   private List <Tarjeta> tarjetas = new ArrayList<>();
//
//    @OneToMany
//    private List<Movimiento> movimientos = new ArrayList<>();

    public Cuenta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


    @Override
    public String toString() {
        return "Cuenta{" +
                "id=" + id +
                ", numeroCuenta='" + numeroCuenta + '\'' +
                ", tipoCuenta='" + tipoCuenta + '\'' +
                ", saldo=" + saldo +
                '}'; //TODO: Agregar campo user
    }
}
