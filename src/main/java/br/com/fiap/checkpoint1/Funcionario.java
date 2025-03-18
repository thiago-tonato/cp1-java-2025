package br.com.fiap.checkpoint1;

public class Funcionario {
    private String nome;
    double horasTrabalhadas;
    private double valorPorHora;

    public Funcionario(String nome, double horasTrabalhadas, double valorPorHora) {
        this.nome = nome;
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorPorHora = valorPorHora;
    }

    public double calcularSalario() {
        return horasTrabalhadas * valorPorHora;
    };

    public void imprimirInformacao() {
        System.out.println("Nome: " + nome);
        System.out.println("Horas trabalhadas: " + horasTrabalhadas);
        System.out.println("Valor por hora: R$ " + valorPorHora);
        System.out.println("Salário: R$ " + calcularSalario());
    }
}
