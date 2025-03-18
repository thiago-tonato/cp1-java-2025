package br.com.fiap.checkpoint1;

public class FuncGerente extends Funcionario{
    private double bonusGerente = 300;


    public FuncGerente(String nome, double horasTrabalhadas, double valorPorHora) {
        super(nome, horasTrabalhadas, valorPorHora);
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + bonusGerente;
    }

    @Override
    public void imprimirInformacao() {
        super.imprimirInformacao();
        System.out.println("Bônus de gerente: R$ " + bonusGerente);
        System.out.println("Salário total com bônus de gerente: R$ " + calcularSalario());
    }
}
