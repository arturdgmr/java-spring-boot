package com.java.oo.solid.singleresponsiblity.solucao;

public class CalculadoraDeSalario {

    public static void main(String[] args) {
        /** DEV */
        Funcionario funcionarioDev = new Funcionario(CargoEnum.DESENVOLVEDOR, 3000);
        System.out.println("Regra de calculo para Dev: " + CargoEnum.DESENVOLVEDOR.getRegraDeCalculo().calcula(funcionarioDev));
        System.out.println("Qual é a regra de calculo para Dev: " + CargoEnum.DESENVOLVEDOR.getRegraDeCalculo().getClass().getSimpleName());

        /** DBA */
        Funcionario funcionarioDBA = new Funcionario(CargoEnum.DBA, 5000);
        System.out.println("Regra de calculo para DBA: " + CargoEnum.DBA.getRegraDeCalculo().calcula(funcionarioDBA));
        System.out.println("Qual é a regra de calculo para DBA: " + CargoEnum.DBA.getRegraDeCalculo().getClass().getSimpleName());
    }
}
