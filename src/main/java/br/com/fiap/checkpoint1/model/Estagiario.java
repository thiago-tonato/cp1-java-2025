package br.com.fiap.checkpoint1.model;

import br.com.fiap.checkpoint1.annotations.Tabela;
import br.com.fiap.checkpoint1.annotations.Coluna;

@Tabela(nome = "TAB_ESTAGIARIO")
public class Estagiario extends Funcionario {

    public Estagiario(String nome, int horasTrabalhadas, double valorPorHora) {
        super(nome, horasTrabalhadas, valorPorHora);
    }

    @Override
    public double calcularSalario() {
        int horasCalculadas = Math.min(getHorasTrabalhadas(), 30);
        return horasCalculadas * getValorPorHora();
    }

    @Override
    public String toString() {
        return "Estagiario{" +
                "nome='" + getNome() + '\'' +
                ", horasTrabalhadas=" + getHorasTrabalhadas() +
                ", valorPorHora=" + getValorPorHora() +
                ", salario=" + calcularSalario() +
                '}';
    }
}

