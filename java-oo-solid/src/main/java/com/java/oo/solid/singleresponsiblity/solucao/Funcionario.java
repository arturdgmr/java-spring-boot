package com.java.oo.solid.singleresponsiblity.solucao;

public class Funcionario {
    private CargoEnum cargo;
    private double salarioBase;

    public Funcionario(CargoEnum cargo, double salarioBase) {
        this.cargo = cargo;
        this.salarioBase = salarioBase;
    }

    public CargoEnum getCargo() {
        return cargo;
    }

    public double getSalarioBase() {
        return salarioBase;
    }
}
