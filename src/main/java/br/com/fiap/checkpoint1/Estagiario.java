package br.com.fiap.checkpoint1;

public class Estagiario extends Funcionario {
    private double bonusEstagio = 20;

    public Estagiario(String nome, double horasTrabalhadas, double valorPorHora) {
        super(nome, horasTrabalhadas, valorPorHora);
    }

    @Override
    public double calcularSalario() {
        double salarioBase = super.calcularSalario();
        return salarioBase - (salarioBase * bonusEstagio);
    }

    @Override
    public void imprimirInformacao() {
        super.imprimirInformacao();
        System.out.println("Desconto estagiário (15%): R$ " + (super.calcularSalario() * bonusEstagio));
        System.out.println("Salário total com desconto: R$ " + calcularSalario());
    }
}
