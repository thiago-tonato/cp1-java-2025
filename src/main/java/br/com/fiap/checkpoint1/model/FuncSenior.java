package br.com.fiap.checkpoint1.model;

import br.com.fiap.checkpoint1.annotations.Coluna;
import br.com.fiap.checkpoint1.annotations.Tabela;
import org.hibernate.annotations.Entity;

import javax.persistence.DiscriminatorValue;

@Tabela(nome = "TAB_FUNCIONARIO")
@Entity
@DiscriminatorValue("Senior")
public class FuncSenior extends Funcionario {

    @Coluna(nome = "bonus")
    private static final double BONUS = 100.0;

    public FuncSenior(String nome, int horasTrabalhadas, double valorPorHora) {
        super(nome, horasTrabalhadas, valorPorHora);
    }

    @Override
    public double calcularSalario() {
        int bonusCount = getHorasTrabalhadas() / 15;
        return super.calcularSalario() + (bonusCount * BONUS);
    }

    @Override
    public void imprimirInformacao() {
        super.imprimirInformacao();
        System.out.println("Bônus aplicado: R$" + ((getHorasTrabalhadas() / 15) * BONUS));
    }
}
