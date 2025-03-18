package br.com.fiap.checkpoint1;

public class Funcionario {
    String nome;
    double horasTrabalhadas;
    double valorPorHora;


    public double calculaSalario() {
        return horasTrabalhadas * valorPorHora;
    };

    @Override
    public String toString() {
        return "Dados do funcionário: \n" +
                "Nome: " + nome + "\n" +
                "Horas trabalhadas no mês: " + horasTrabalhadas + "\n" +
                "Valor pago por hora: " + valorPorHora;
    }
}
