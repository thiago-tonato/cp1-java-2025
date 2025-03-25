package br.com.fiap.checkpoint1.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Gerente")
public class FuncGerente extends Funcionario {

    @Column(name = "bonus_gerente")
    private static final double BONUS_GERENTE = 500.0;

    public FuncGerente(String nome, int horasTrabalhadas, double valorPorHora) {
        super(nome, horasTrabalhadas, valorPorHora);
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + BONUS_GERENTE;
    }
}
