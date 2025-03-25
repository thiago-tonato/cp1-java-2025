package br.com.fiap.checkpoint1.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Junior")
public class FuncJunior extends Funcionario {

  @Column(name = "bonus_junior")
  private static final double BONUS_JUNIOR = 50.0;

  public FuncJunior(String nome, int horasTrabalhadas, double valorPorHora) {
    super(nome, horasTrabalhadas, valorPorHora);
  }

  @Override
  public double calcularSalario() {
    return super.calcularSalario() + BONUS_JUNIOR;
  }

  @Override
  public void imprimirInformacao() {
    super.imprimirInformacao();
    System.out.println("Bônus Junior aplicado: R$" + BONUS_JUNIOR);
  }
}