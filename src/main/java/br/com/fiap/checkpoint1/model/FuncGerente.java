package br.com.fiap.checkpoint1.model;

import org.hibernate.annotations.Entity;

import javax.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("Gerente")
public class FuncGerente extends Funcionario {

    private static final double BONUS_GERENTE = 500.0;

    public FuncGerente(String nome, int horasTrabalhadas, double valorPorHora) {
        super(nome, horasTrabalhadas, valorPorHora);
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + BONUS_GERENTE;
    }
}
