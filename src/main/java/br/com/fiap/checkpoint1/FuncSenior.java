package br.com.fiap.checkpoint1;

public class FuncSenior extends Funcionario{
    private double bonusSenior = 100;


    public FuncSenior(String nome, double horasTrabalhadas, double valorPorHora) {
        super(nome, horasTrabalhadas, valorPorHora);
    }

    @Override
    public double calcularSalario() {
        double salarioBase = super.calcularSalario();
        double bonus = (int) (super.horasTrabalhadas / 15) * bonusSenior;
        return salarioBase + bonus;
    }


    @Override
    public void imprimirInformacao() {
        super.imprimirInformacao();
        System.out.println("Bônus sênior: R$ " + ((int) (super.horasTrabalhadas / 15) * bonusSenior));
        System.out.println("Salário total com bônus: R$ " + calcularSalario());
    }
}
