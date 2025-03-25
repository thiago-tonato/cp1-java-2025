package br.com.fiap.checkpoint1.model;

import br.com.fiap.checkpoint1.annotations.Coluna;
import br.com.fiap.checkpoint1.annotations.Tabela;
import org.hibernate.annotations.Entity;

import javax.persistence.DiscriminatorValue;

@Tabela(nome = "TAB_FUNCIONARIO")
@Entity
@DiscriminatorValue("Gerente")
public class FuncGerente extends Funcionario {

    @Coluna(nome = "bonus_gerente")
    private static final double BONUS_GERENTE = 500.0;

    public FuncGerente(String nome, int horasTrabalhadas, double valorPorHora) {
        super(nome, horasTrabalhadas, valorPorHora);
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + BONUS_GERENTE;
    }
}
